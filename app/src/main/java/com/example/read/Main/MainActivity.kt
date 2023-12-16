package com.example.read.Main

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.read.R
import com.example.read.Web.SelectActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        list.add(Book("刀剑神域第14卷",R.drawable.p1))
        list.add(Book("刀剑神域第15卷",R.drawable.p2))
        list.add(Book("刀剑神域第16卷",R.drawable.p3))
        list.add(Book("刀剑神域第18卷",R.drawable.p4))
        list.add(Book("刀剑神域第20卷",R.drawable.p5))
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = layoutManager
        val adapter = BookAdapter(list)
        recycler.adapter =adapter
        val button = findViewById<FloatingActionButton>(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this, SelectActivity::class.java)
            startActivity(intent)
        }
    }
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        return if (event.keyCode == KeyEvent.KEYCODE_BACK) {true}
        else {super.dispatchKeyEvent(event)}
    }
}