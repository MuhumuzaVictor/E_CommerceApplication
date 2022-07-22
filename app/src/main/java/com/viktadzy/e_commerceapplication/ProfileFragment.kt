package com.viktadzy.e_commerceapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.viktadzy.e_commerceapplication.databinding.FragmentLogOutBinding
import com.viktadzy.e_commerceapplication.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
     var database = FirebaseDatabase.getInstance().reference


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding= FragmentProfileBinding.inflate(layoutInflater)
        binding.editProfile.setOnClickListener{


            val intent = Intent(this.requireContext(), Editprofile::class.java)
            startActivity(intent)
        }

        var getdata = object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder()
                for(i in p0.children){
                        var uname = i.child("username").getValue()
                        var uemail= i.child("useremail").getValue()
                        var uphone= i.child("phonenumber").getValue()
                        var ubio= i.child("bio").getValue()

                    sb.append("${i.key} $uname $uemail $uphone $ubio")
                }
                binding.username.setText(sb)
                binding.useremail.setText(sb)
                binding.phone.setText(sb)
                binding.bio.setText(sb)


            }

            override fun onCancelled(p0: DatabaseError) {

            }

        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)


        return binding.root
    }


}


