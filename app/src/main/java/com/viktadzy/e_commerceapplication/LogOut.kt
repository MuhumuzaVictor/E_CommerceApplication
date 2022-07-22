package com.viktadzy.e_commerceapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.viktadzy.e_commerceapplication.databinding.FragmentLogOutBinding
import java.security.Signature


class LogOut : Fragment() {

    private lateinit var binding: FragmentLogOutBinding
    private lateinit var user: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater!!.inflate(R.layout.fragment_log_out, container, false)

        user= FirebaseAuth.getInstance()
        binding.logoutbtn.setOnClickListener{
            user.signOut()
            requireActivity().run{
                startActivity(Intent(this,SignUpActivity::class.java))
                finish()
            }

        }


        return view
    }
}