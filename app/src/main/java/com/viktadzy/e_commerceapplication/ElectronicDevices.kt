package com.viktadzy.e_commerceapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viktadzy.e_commerceapplication.databinding.FragmentElectronicDevicesBinding

class ElectronicDevices : Fragment() {

    private lateinit var binding: FragmentElectronicDevicesBinding

    private lateinit var itemTitles:Array<String>
    private lateinit var itemImages:Array<Int>
    private lateinit var itemLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentElectronicDevicesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Data source
        itemLinks = arrayOf(
            "https://www.jumia.ug/phones-tablets/",
            "https://www.jumia.ug/computing/",
            "https://www.jumia.ug/catalog/?q=speakers",
            "https://www.jumia.ug/catalog/?q=tvs",
            "https://www.jumia.ug/catalog/?q=digital+camera",
            "https://www.jumia.ug/catalog/?q=watches"
        )

        itemTitles = arrayOf("MobilePhones",
            "Computers",
            "Speakers",
            "TV's",
            "Digital Camera",
            "Watches"
        )
        itemImages = arrayOf(R.drawable.mobilephones, R.drawable.computer, R.drawable.speaker,
            R.drawable.tv,R.drawable.digitalcamera, R.drawable.watches
        )

        arrayList = arrayListOf()

        for (i in itemTitles.indices){
            val rowItem = Data(itemTitles[i], itemImages[i])
            arrayList.add(rowItem)
        }

        val gridView = binding.gridViewelectronics

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