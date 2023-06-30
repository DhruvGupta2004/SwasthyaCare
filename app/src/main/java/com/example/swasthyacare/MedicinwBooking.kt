package com.example.swasthyacare

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MedicinwBooking : AppCompatActivity() {

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicinw_booking)

        val ifees = intent.getStringExtra("fees")
        val iname = intent.getStringExtra("name")
        val uimage = intent.getIntExtra("image", R.drawable.doctor)

        val tvname = findViewById<TextView>(R.id.doctor_name)
        val tvfees = findViewById<TextView>(R.id.doctor_fees)
        val tvimage = findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.profile_image)
        val confirm = findViewById<Button>(R.id.btnconfirm)

        val pname = findViewById<TextInputEditText>(R.id.pname)
        val umar = findViewById<TextInputEditText>(R.id.age)
        val contact = findViewById<TextInputEditText>(R.id.cn)
        val pin = findViewById<TextInputEditText>(R.id.date)

        tvname.text = iname
        tvfees.text = ifees
        tvimage.setImageResource(uimage)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.medicine_confirm)

        val buttongood = dialog.findViewById<Button>(R.id.btnback)

        buttongood.setOnClickListener {
            dialog.dismiss()
            val mainPage = Intent(this, MainActivity::class.java)
            startActivity(mainPage)
        }

        confirm.setOnClickListener {

            if ((pname.text.toString()).isNotEmpty() && (umar.text.toString()).isNotEmpty() && (contact.text.toString()).isNotEmpty()) {
                if (contact.length() == 10) {
                    if (pin.length() == 6) {
                        dialog.show()
                    } else {
                        Toast.makeText(this, "enter a vaild Pincode", Toast.LENGTH_SHORT).show()
                    }
                    dialog.show()
                } else {
                    Toast.makeText(this, "enter a vaild contact number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Kindly fill all the Details", Toast.LENGTH_SHORT).show()
            }

        }
    }
}