package com.example.read.Web

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.read.R


class SelAdapter (private val selList: MutableList<String>):RecyclerView.Adapter<SelAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt: TextView = view.findViewById(R.id.t)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_sel, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.txt.setOnClickListener {
            val position = viewHolder.adapterPosition
            val pict = selList[position]
            val intent = Intent(parent.context, WebActivity::class.java)
            intent.putExtra("W",pict)
            parent.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount(): Int = selList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = selList[position]
        holder.txt.text = word
    }
}