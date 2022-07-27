package com.viktadzy.e_commerceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Profile : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val userlog = findViewById<TextView>(R.id.userlogout)
        userlog.setOnClickListener{
            val intent = Intent(this,LogOut::class.java)
            startActivity(intent)

            val usernameNav = findViewById<TextView>(R.id.see_username)
            val emailNav = findViewById<TextView>(R.id.see_email)

            if (auth.currentUser != null){
                val email = auth.currentUser!!.email
                emailNav.text = email

            }

        }
    }
}