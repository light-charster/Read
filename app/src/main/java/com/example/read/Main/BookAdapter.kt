package com.example.read.Main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.read.R
import com.example.read.Read.ReadActivity


class BookAdapter (private val pictureList: List<Book>):RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image :ImageView = view.findViewById(R.id.image)
        val text :TextView =view.findViewById(R.id.text)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_book,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.image.setOnClickListener{
            val position = viewHolder.adapterPosition
            val pict = pictureList[position]
            val picture = pict.name
            val intent = Intent(parent.context, ReadActivity::class.java)
            intent.putExtra("E",picture)
            parent.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount(): Int =pictureList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val picture =pictureList[position]
        holder.image.setImageResource(picture.id)
        holder.text.text = picture.name
    }
}