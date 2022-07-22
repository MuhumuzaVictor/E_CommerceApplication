package com.viktadzy.e_commerceapplication.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.viktadzy.e_commerceapplication.Model
import com.viktadzy.e_commerceapplication.R

import com.viktadzy.e_commerceapplication.databinding.FragmentHomeBinding
import com.viktadzy.e_commerceapplication.itemDetails
import java.sql.Array

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)



        return view
    }



    }



