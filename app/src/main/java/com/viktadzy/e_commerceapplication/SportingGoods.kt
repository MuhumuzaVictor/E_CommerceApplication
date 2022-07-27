package com.viktadzy.e_commerceapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viktadzy.e_commerceapplication.databinding.FragmentElectronicDevicesBinding
import com.viktadzy.e_commerceapplication.databinding.FragmentSportingGoodsBinding


class SportingGoods : Fragment() {


    private lateinit var binding: FragmentSportingGoodsBinding

    private lateinit var itemTitles:Array<String>
    private lateinit var itemImages:Array<Int>
    private lateinit var itemLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSportingGoodsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Data source
        itemLinks = arrayOf(
            "https://www.jumia.ug/phones-tablets/",
            "https://www.jumia.ug/computing/",
            "https://www.jumia.ug/catalog/?q=speakers",
            "https://www.jumia.ug/catalog/?q=tvs"

        )

        itemTitles = arrayOf("Sports and Fitness",
            "Outdoor & Recreation",
            "Outdoor & Adventure",
            "Racquet Sports",

        )
        itemImages = arrayOf(R.drawable.gym, R.drawable.tent, R.drawable.smartwatch,
            R.drawable.racket
        )

        arrayList = arrayListOf()

        for (i in itemTitles.indices){
            val rowItem = Data(itemTitles[i], itemImages[i])
            arrayList.add(rowItem)
        }

        val gridView = binding.gridViewsporting

        gridView.adapter = activity?.let { CustomAdapter(it, arrayList) }
        gridView.isClickable = true


        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(this.requireContext(), WebViewInflater::class.java)

            intent.putExtra("urls", itemLinks[position])

            startActivity(intent)
        }
        return root

    }


}