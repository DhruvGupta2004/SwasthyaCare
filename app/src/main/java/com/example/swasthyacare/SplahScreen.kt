package com.example.swasthyacare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplahScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splah_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
            val intent = Intent(this, SignInPage::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}