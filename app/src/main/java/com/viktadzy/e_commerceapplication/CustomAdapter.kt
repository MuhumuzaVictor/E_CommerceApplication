package com.viktadzy.e_commerceapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView



class CustomAdapter(private val context: Context, private val arrayList:ArrayList<Data>):BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position.toLong()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val layoutView = inflater.inflate(R.layout.item_layout_gridview, viewGroup, false)
        layoutView.findViewById<TextView>(R.id.item_title).text = arrayList[position].itemtitle
        layoutView.findViewById<ImageView>(R.id.item_image).setImageResource(arrayList[position].itemimage)

        return layoutView
    }

}