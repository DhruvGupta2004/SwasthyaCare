package com.example.swasthyacare

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.swasthyacare.fragments.Doctor.doctor_home
import com.example.swasthyacare.home.HomeFrag
import com.example.swasthyacare.lab.test.LabMain
import com.example.swasthyacare.pharmacy.MedicineHome
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var Toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val naview: NavigationView = findViewById(R.id.nav_view)

        Toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(Toggle)
        Toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        replaceFrgment(HomeFrag())

        val logout = Intent(this, SignInPage::class.java)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.rating)


        naview.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.home -> replaceFrgment(HomeFrag())

                R.id.doctor -> replaceFrgment(doctor_home())

                R.id.medicine -> replaceFrgment(MedicineHome())

                R.id.LabTest -> replaceFrgment(LabMain())

                R.id.nav_rate ->{
                    dialog.show()
                    val submit = dialog.findViewById<Button>(R.id.button)
                    submit.setOnClickListener {
                        dialog.dismiss()
                        Toast.makeText(applicationContext ,"Thanku for your feedback",Toast.LENGTH_SHORT).show()
                    }
                }

                R.id.nav_share ->{
                    val url = "https://github.com/DhruvGupta2004"
                    val intent =Intent(Intent.ACTION_SEND)
                    intent.type ="text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT ,url)
                    val chooser = Intent.createChooser(intent, "Share using...")
                    startActivity(chooser)
                }

                R.id.nav_logout -> {startActivity(logout)
                finish()
                }

            }
            true
        }
    }

    lateinit var dialog: Dialog


    private fun replaceFrgment(doctorFragment: Fragment) {

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val fragmentManager = supportFragmentManager
        val FragmentTransaction = fragmentManager.beginTransaction()
        FragmentTransaction.replace(R.id.framelayout , doctorFragment)
        FragmentTransaction.addToBackStack(null)
        FragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (Toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}