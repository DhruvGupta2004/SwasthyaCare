package com.example.swasthyacare.fragments.Doctor

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swasthyacare.Booking_page
import com.example.swasthyacare.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var adapter : MyAdapter
lateinit var myrecyclerview :RecyclerView
lateinit var information :ArrayList<Details>

lateinit var imageId :Array<Int>
lateinit var Name :Array<String>
lateinit var speciality :Array<String>
lateinit var fees :Array<String>


/**
 * A simple [Fragment] subclass.
 * Use the [doctorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class doctorFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_doctor, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment doctorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            doctorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        

        val layoutManager = LinearLayoutManager(context)
        myrecyclerview = view.findViewById(R.id.recyclerView)
        myrecyclerview.layoutManager = layoutManager
        myrecyclerview.setHasFixedSize(true)
        adapter = MyAdapter(information ,this)
        myrecyclerview.adapter = adapter

        var myAdapter = MyAdapter(information ,this)
        myrecyclerview.adapter =myAdapter
        myAdapter.setOnItemClickListener(object :MyAdapter.onItemClickListner{
            override fun onItemClick(position: Int) {
                val intent = Intent(activity ,Booking_page::class.java)
                intent.putExtra("name" , information[position].name)
                intent.putExtra("image" , information[position].image)
                intent.putExtra("fees" , information[position].fees)

                startActivity(intent)
            }

        })

    }


    private fun dataInitialize(){

        information = arrayListOf<Details>()

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.a,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
        )

        Name  = arrayOf("Dr.Aayushi","Dr.Yash","Dr.Sunny","Dr.Riya","Dr.Manish","Dr.Rai","Dr.james")
        speciality = arrayOf("Exp = 4yrs","Exp = 6yrs","Exp = 3yrs","Exp = 7yrs","Exp = 9yrs","Exp = 4yrs","Exp = 1yrs")
        fees = arrayOf("500","700","300","900","400","700","500")
        for (i in imageId.indices){
            val con = Details(imageId[i] , Name[i] , speciality[i] , fees[i])
            information.add(con)
        }


    }
}