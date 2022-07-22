package com.viktadzy.e_commerceapplication


import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Editprofile : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var bio: EditText
    private lateinit var saveBtn: Button


    private lateinit var auth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        saveBtn = findViewById<Button>(R.id.saveBtn)
        userName = findViewById<EditText>(R.id.userName)
        email = findViewById<EditText>(R.id.email)
        phone = findViewById<EditText>(R.id.Phone)
        bio = findViewById<EditText>(R.id.bio)


        auth = FirebaseAuth.getInstance()

        saveBtn.setOnClickListener {
            saveprofile()
        }

    }

    private fun saveprofile() {
        val username = userName.text.toString()
        val useremail = email.text.toString()
        val phonenumber = phone.text.toString()
        val userbio = bio.text.toString()

        if (username.isEmpty()) {
            userName.error = "Please enter name"
        }
        if (useremail.isEmpty()) {
            email.error = "Please enter email"
        }
        if (phonenumber.isEmpty()) {
            phone.error = "Please enter phone number"
        }
        if (userbio.isEmpty()) {
            bio.error = "Please enter bio"
        } else {

            val uid = auth.currentUser?.uid
            dbRef = FirebaseDatabase.getInstance().getReference(("users"))
            val user = User(username, useremail, phonenumber, userbio)
            if (uid != null) {
                dbRef.child(uid).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful) {

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Successfully updated profile", Toast.LENGTH_SHORT)
                            .show()

                    } else {
                        Toast.makeText(this, "Failed to update profile", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}
