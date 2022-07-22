package com.viktadzy.e_commerceapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class itemDetails: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_details)

        val bundle =intent.extras
        findViewById<ImageView>(R.id.itemimage).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.itemname).text=bundle!!.getString("name")
        findViewById<TextView>(R.id.itemdetails).text=bundle!!.getString("content")

    }
}