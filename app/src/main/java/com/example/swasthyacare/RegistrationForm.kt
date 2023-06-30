package com.example.swasthyacare

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrationForm : AppCompatActivity() {

    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)


        supportActionBar?.hide()

        val register = findViewById<Button>(R.id.etbtnRegister)
        val terms = findViewById<CheckBox>(R.id.etcheckBox)
        val username = findViewById<TextInputEditText>(R.id.etname)
        val email = findViewById<TextInputEditText>(R.id.etemail_id)
        val pass = findViewById<TextInputEditText>(R.id.etpassword)
        val btnsignin = findViewById<Button>(R.id.etsignin)
        val repassword = findViewById<TextInputEditText>(R.id.etrepassword)


        register.setOnClickListener{
            val name= username.text.toString()
            val mail= email.text.toString()
            val password= pass.text.toString()
            val passwordcheck = repassword.text.toString()
            val user= User(name ,mail, password)


            if(name.isNotEmpty() && mail.isNotEmpty() && password.isNotEmpty() && terms.isChecked){

                if (mail.length == 10) {
                    if (password==passwordcheck){
                        database = FirebaseDatabase.getInstance().getReference("Users")
                        database.child(mail).setValue(user).addOnSuccessListener {
                            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()

                            val openSignInPage = Intent(this , SignInPage::class.java)
                            startActivity(openSignInPage)

                        }.addOnFailureListener {
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        Toast.makeText(this, "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "enter a vaild contact number", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Kindly fill all the details and accept terms and condition", Toast.LENGTH_SHORT).show()
            }

        }

        btnsignin.setOnClickListener{
            val openSignInPage = Intent(this , SignInPage::class.java)
            startActivity(openSignInPage)
        }

//        terms.setOnClickListener{
//            if (terms.isChecked){
//                //open
//            }
//            else{
//                terms.buttonTintList = ColorStateList.valueOf(Color.RED)
////                Toast.makeText(this, "please accept the terms and conditions", Toast.LENGTH_SHORT).show()
//            }
//          }
    }
}