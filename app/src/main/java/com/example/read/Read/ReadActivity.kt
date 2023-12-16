package com.example.read.Read

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.read.R

class ReadActivity : AppCompatActivity() {
    private var mToPosition: Int = 0
    private var mShouldScroll: Boolean = false
    private var name:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        val sharedPreferences = this.getSharedPreferences("txt", MODE_PRIVATE)
        val nam = intent.getStringExtra("E")
        val fileName = "$nam.txt"
        name=fileName
        val position = sharedPreferences.getInt(name, 0)
        val file = this.resources.assets.open(fileName)
        val myList = file.bufferedReader().readLines().toMutableList()
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val recycler = findViewById<RecyclerView>(R.id.rec)
        recycler.layoutManager = layoutManager
        val adapter = TxtAdapter(myList)
        recycler.adapter = adapter
        val firstItem = recycler.getChildLayoutPosition(recycler.getChildAt(0))
        val lastItem = recycler.getChildLayoutPosition(recycler.getChildAt(recycler.childCount - 1))
        if (position < firstItem) {
            recycler.scrollToPosition(position)
        } else if (position <= lastItem) {
            val movePosition = position - firstItem
            if (movePosition >= 0 && movePosition < recycler.childCount) {
                val top = recycler.getChildAt(movePosition).top
                recycler.smoothScrollBy(0, top)
            }
        } else {
            recycler.scrollToPosition(position)
            mToPosition = position
            mShouldScroll = true
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        val recycler = findViewById<RecyclerView>(R.id.rec)
        val firstItem = recycler.getChildLayoutPosition(recycler.getChildAt(0))
        val con=this.getSharedPreferences("txt", MODE_PRIVATE).edit()
        con.putInt(name,firstItem)
        con.apply()
    }
}
