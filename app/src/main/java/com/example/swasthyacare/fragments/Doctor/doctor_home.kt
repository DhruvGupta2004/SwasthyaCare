package com.example.swasthyacare.fragments.Doctor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swasthyacare.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [doctor_home.newInstance] factory method to
 * create an instance of this fragment.
 */
class doctor_home : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_doctor_home, container, false)
        // Inflate the layout for this fragment
        return itemView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment doctor_home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            doctor_home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val physician = view.findViewById<CardView>(R.id.physician)
        val dentist = view.findViewById<CardView>(R.id.dentist)
        val cardiologist = view.findViewById<CardView>(R.id.cardiologist)
        val surgen = view.findViewById<CardView>(R.id.surgen)
        val optomertrist = view.findViewById<CardView>(R.id.optometrist)
        val dietitian = view.findViewById<CardView>(R.id.dietitian)


        physician.setOnClickListener(){
            Toast.makeText(activity, "YOUR PHYSICIANS ARE HERE",Toast.LENGTH_SHORT).show()
            val list = doctor_home()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.drawerLayout ,doctorFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        dentist.setOnClickListener(){
            Toast.makeText(activity, "YOUR DENTISTS ARE HERE",Toast.LENGTH_SHORT).show()
            val list = doctor_home()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.drawerLayout ,doctorFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        cardiologist.setOnClickListener(){
            Toast.makeText(activity, "YOUR CARDIOLOGISTS ARE HERE",Toast.LENGTH_SHORT).show()
            val list = doctor_home()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.drawerLayout ,doctorFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        surgen.setOnClickListener(){
            Toast.makeText(activity, "YOUR SURGEONS ARE HERE",Toast.LENGTH_SHORT).show()
            val list = doctor_home()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.drawerLayout ,doctorFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        optomertrist.setOnClickListener(){
            Toast.makeText(activity, "YOUR OPTOMERTRIST ARE HERE",Toast.LENGTH_SHORT).show()
            val list = doctor_home()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.drawerLayout ,doctorFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        dietitian.setOnClickListener(){
            Toast.makeText(activity, "YOUR DIETITIAN ARE HERE",Toast.LENGTH_SHORT).show()
            val list = doctor_home()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.drawerLayout ,doctorFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }



    }
}