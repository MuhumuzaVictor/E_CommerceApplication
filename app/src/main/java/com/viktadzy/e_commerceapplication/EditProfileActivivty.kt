 package com.viktadzy.e_commerceapplication

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.viktadzy.e_commerceapplication.databinding.ActivityEditProfileActivivtyBinding

 class EditProfileActivivty : AppCompatActivity() {

     private lateinit var binding: ActivityEditProfileActivivtyBinding
     private lateinit var auth: FirebaseAuth
     private lateinit var databaseReference: DatabaseReference

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityEditProfileActivivtyBinding.inflate(layoutInflater)
         setContentView(binding.root)

         val gohome: Button = findViewById(R.id.goToHome)
         gohome.setOnClickListener{
             val intent = Intent(this,MainActivity::class.java)
             startActivity(intent)
         }


         //to link fragments with other activities
        val btnsaveprofile: Button = findViewById(R.id.savebtn)
         btnsaveprofile.setOnClickListener{
             val profilefragment = ProfileFragment()
             val fragment: Fragment?=
                 supportFragmentManager.findFragmentByTag(ProfileFragment::class.java.simpleName)

             if(fragment !is ProfileFragment){
                 supportFragmentManager.beginTransaction()
                     .add(R.id.container_fragment, profilefragment,ProfileFragment::class.java.simpleName)
                     .commit()

             }
             btnsaveprofile.visibility = View.GONE
         }


         auth = FirebaseAuth.getInstance()
         val uid = auth.currentUser?.uid
         databaseReference = FirebaseDatabase.getInstance().getReference("Users")
         binding.savebtn.setOnClickListener{

             title = "Updating profile"
             val progressDialog = ProgressDialog(this)
             progressDialog.setTitle("Updating profile")
             progressDialog.setMessage("Application is loading, please wait...")
             progressDialog.show()

             val Username = binding.inputUsername.text.toString()
             val Bio = binding.inputBio.text.toString()
             val Birthdate = binding.inputBirthdate.text.toString()
             val useremail= binding.inputUseremail.text.toString()

             val user=User(Username,useremail,Bio,Birthdate)
             if (uid != null){

                 databaseReference.child(uid).setValue(user).addOnCompleteListener {

                     if(it.isSuccessful){

                         Toast.makeText(this,"Successfuly updated profile", Toast.LENGTH_SHORT).show()

                     }else{

                         Toast.makeText(this,"Failed to update profile", Toast.LENGTH_SHORT).show()
                     }
                 }
             }
         }
     }
 }