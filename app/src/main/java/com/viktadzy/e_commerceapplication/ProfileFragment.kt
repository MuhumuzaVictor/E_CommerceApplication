package com.viktadzy.e_commerceapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.viktadzy.e_commerceapplication.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //to link a fragment with another activity
        val bind = FragmentProfileBinding.inflate(layoutInflater)

        bind.editProfile.setOnClickListener{
            val intent = Intent(this.requireContext(), EditProfileActivivty::class.java)
            startActivity(intent)
        }
     return bind.root
    }


}