package com.example.recyclerview

import android.view.LayoutInflater
import android.view.TextureView
import  android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter constructor(var names : List<String>,var layout: Int, var itemListener  :OnItemClikListener)
    :RecyclerView.Adapter<MyAdapter.ViewHolder?> (){

    interface OnItemClikListener {
        fun onItemClick(name : String?, position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view :View = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        val vh = ViewHolder(view)
        return vh
    }

    override fun getItemCount(): Int {

        return names.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(names.get(position), itemListener);
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var txtViewName : TextView = itemView.findViewById<View>(R.id.textViewName) as TextView
        fun bind (name : String?, itemListener: OnItemClikListener){
            txtViewName.text = name
            itemView.setOnClickListener{
                itemListener.onItemClick(name, absoluteAdapterPosition)
            }
        }
    }


}