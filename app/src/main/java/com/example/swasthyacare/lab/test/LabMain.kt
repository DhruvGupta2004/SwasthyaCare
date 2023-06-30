package com.example.swasthyacare.lab.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swasthyacare.LabBooking
import com.example.swasthyacare.MedicinwBooking
import com.example.swasthyacare.R
import com.example.swasthyacare.pharmacy.medicineAdapter
import com.example.swasthyacare.pharmacy.medicine_details

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [LabMain.newInstance] factory method to
 * create an instance of this fragment.
 */


lateinit var adapter : LabAdapter
lateinit var myrecyclerview : RecyclerView
lateinit var LabDetails :ArrayList<User>

lateinit var imageId :Array<Int>
lateinit var Name :Array<String>
lateinit var speciality :Array<String>
lateinit var fees :Array<String>

class LabMain : Fragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lab_main, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LabMain.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LabMain().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()


        val lablayoutManager = LinearLayoutManager(context)
        myrecyclerview = view.findViewById(R.id.recyclerViewLab)
        myrecyclerview.layoutManager = lablayoutManager
        myrecyclerview.setHasFixedSize(true)
        adapter = LabAdapter(LabDetails)
        myrecyclerview.adapter = adapter

        var myAdapter = LabAdapter(LabDetails)
        myrecyclerview.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : LabAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
                val intent = Intent(activity, LabBooking::class.java)
                intent.putExtra("name", LabDetails[position].name)
                intent.putExtra("image", LabDetails[position].image)
                intent.putExtra("fees", LabDetails[position].fees)

                startActivity(intent)
            }

        })

    }


    fun dataInitialize() {

        LabDetails = arrayListOf<User>()

        imageId = arrayOf(
            R.drawable.blood_drop,
            R.drawable.heartcheck,
            R.drawable.x,
            R.drawable.baseline_monitor_heart_24
        )

        Name = arrayOf(
            "BLOOD CHECK UP",
            "FULL BODY CHECKUP",
            "X-rays",
            "HEART CHECKUP",
        )
        speciality = arrayOf(
            "Book Blood Test At Home Delhi @ Healthians. @ Rs299. Free Sample Collection + Doctor Advice.",
            "Test for blood sugar, cholesterol, thyroid, and more with Smart Health Checkup. Book Now! Get a Free Home Sample Collection + Flat ₹100 Off on your first test. Book a test now!",
            "Medical x-rays are used to generate images of tissues and structures inside the body",
            "Regular cardiovascular screening is important because it helps you detect risk factors in their earliest stages. ",
        )
        fees = arrayOf("299", "1299", "499", "799")
        for (i in imageId.indices) {
            val thing = User(Name[i], speciality[i], fees[i] ,imageId[i])
            LabDetails.add(thing)
        }


    }
}