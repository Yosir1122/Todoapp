package com.example.todoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.todoapp.R
import com.example.todoapp.models.MySpinner

class SpinnerAdapter(var list:List<MySpinner>?):BaseAdapter() {
    override fun getCount(): Int=list!!.size

    override fun getItem(position: Int): Any {
        return list!![position]
    }

    override fun getItemId(position: Int): Long =position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView:View
        if (convertView==null){
            itemView=LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner,convertView,false)
        }else{
            itemView=convertView
        }
        itemView.findViewById<ImageView>(R.id.imgSpinner)
            .setImageResource(list!![position].flag)
        itemView.findViewById<TextView>(R.id.tvSpinner)
            .text=list!![position].name
        return itemView
    }
}