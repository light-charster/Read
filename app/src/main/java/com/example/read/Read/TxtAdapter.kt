package com.example.read.Read

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.read.R


class TxtAdapter(private val txtList: MutableList<String>) :RecyclerView.Adapter<TxtAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt: TextView = view.findViewById(R.id.txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_txt, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = txtList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = txtList[position]
        holder.txt.text = word
    }
}