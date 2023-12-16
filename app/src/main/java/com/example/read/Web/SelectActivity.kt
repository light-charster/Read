package com.example.read.Web

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.read.R

class SelectActivity : AppCompatActivity() {
    private val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        supportActionBar?.hide()
        val con=this.getSharedPreferences("web", MODE_PRIVATE).edit()
        con.putString("笔趣阁","https://www.biqg.cc/")
        con.putString("菠萝包","https://m.sfacg.com/")
        con.putString("起点中文网","https://www.qidian.com/")
        con.putString("番茄小说网","https://fanqienovel.com/")
        con.putString("QQ阅读","https://book.qq.com/")
        con.apply()
        list.add("笔趣阁")
        list.add("菠萝包")
        list.add("起点中文网")
        list.add("番茄小说网")
        list.add("QQ阅读")
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val recycler = findViewById<RecyclerView>(R.id.se)
        recycler.layoutManager = layoutManager
        val adapter = SelAdapter(list.toMutableList())
        recycler.adapter =adapter
    }
}