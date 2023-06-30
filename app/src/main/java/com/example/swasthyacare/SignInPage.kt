package com.example.swasthyacare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.security.Key

class SignInPage : AppCompatActivity() {

    lateinit var databaseReference: DatabaseReference

    companion object{
        const val KEY = "com.example.swasthyacare.SignInPage.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sign_in_page)

        supportActionBar?.hide()

        val signIn = findViewById<Button>(R.id.btnSignIn)
        val id = findViewById<TextInputEditText>(R.id.username)
        val pass = findViewById<TextInputEditText>(R.id.password)

        signIn.setOnClickListener{

            val userId = id.text.toString()
            if (userId.isNotEmpty()){
                readData(userId)
            }
            else{
                Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show()
            }
        }

        val newRegistration = findViewById<TextView>(R.id.NewRegistration)

        // path of new registration
        newRegistration.setOnClickListener{
            intent = Intent(applicationContext, RegistrationForm::class.java)
            startActivity(intent)
        }

    }

    // if user already have an account

    private fun readData(userId: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(userId).get().addOnSuccessListener {

            if(it.exists()){

                // here we check the passWord weather it is right or not
                val checkPass = it.child("password").value

                val cPass = findViewById<TextInputEditText>(R.id.password)
                val pass = cPass.text.toString()

                if (checkPass==pass){

                    //if password is right
                    //next activity start here
                    val intentWelcome = Intent(this, MainActivity::class.java)

                    //find  name from database
                    val ename = it.child("name").value
//                    val intent = Intent(this, HomePage::class.java)

                    //pass data(name) in homepage
                    intentWelcome.putExtra(KEY ,ename.toString())
                    startActivity(intentWelcome)
                    finish()

                }
                else{
                    Toast.makeText(this , "Incorrect Password" , Toast.LENGTH_SHORT).show()
                }

            }
            // if user not have account
            else{
                Toast.makeText(this, "User not exists", Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener{
            Toast.makeText(this, "error in db , pls try again ", Toast.LENGTH_SHORT).show()

        }
    }
}