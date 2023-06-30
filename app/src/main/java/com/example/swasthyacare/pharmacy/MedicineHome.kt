package com.example.swasthyacare.pharmacy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swasthyacare.Booking_page
import com.example.swasthyacare.MedicinwBooking
import com.example.swasthyacare.R
import com.example.swasthyacare.fragments.Doctor.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



lateinit var adapter : medicineAdapter
lateinit var myrecyclerview : RecyclerView
lateinit var medicineDetails :ArrayList<medicine_details>

lateinit var imageId :Array<Int>
lateinit var Name :Array<String>
lateinit var speciality :Array<String>
lateinit var fees :Array<String>

/**
 * A simple [Fragment] subclass.
 * Use the [medicine_home.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicineHome : Fragment() {
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
        return inflater.inflate(R.layout.fragment_medicine_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment medicine_home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MedicineHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()


        val MedicinelayoutManager = LinearLayoutManager(context)
        myrecyclerview = view.findViewById(R.id.recyclerViewMedi)
        myrecyclerview.layoutManager = MedicinelayoutManager
        myrecyclerview.setHasFixedSize(true)
        adapter = medicineAdapter(medicineDetails)
        myrecyclerview.adapter = adapter

        var myAdapter = medicineAdapter(medicineDetails)
        myrecyclerview.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : medicineAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
                val intent = Intent(activity, MedicinwBooking::class.java)
                intent.putExtra("name", medicineDetails[position].name)
                intent.putExtra("image", medicineDetails[position].image)
                intent.putExtra("fees", medicineDetails[position].fees)

                startActivity(intent)
            }

        })

    }


    fun dataInitialize() {

        medicineDetails = arrayListOf<medicine_details>()

        imageId = arrayOf(
            R.drawable.levipil,
            R.drawable.maxoza,
            R.drawable.iodex,
            R.drawable.disprin,
            R.drawable.volini,
            R.drawable.moov,
            R.drawable.omnigel,
        )

        Name = arrayOf(
            "Levipil 500mg Tablet 10'S",
            "Maxoza L Powder 5gm",
            "Iodex Body Pain Expert 40 gm",
            "Disprin Regular Effervescent Tablet 10'S",
            "Volini Spray 15gm",
            "Moov Pain Relief Specialist Cream 30 gm",
            "Omnigel Gel(Topical) 50gm"
        )
        speciality = arrayOf(
            "Levipil tablet is an anti-epileptic medication and is used in the treatment of different forms of epilepsy, commonly known as seizures or fits.",
            "Maxoza L Powder is a nutritional supplement that treats nutritional deficiencies and aids in the growth and development of the body.",
            "The assessment is based on a standard specification of iron ore fines with 62% iron, 2.25% alumina, 4% silica and 0.09% phosphorus, among other gangue elements.",
            "For the relief of mild to moderate pain in headaches, including migraine headaches, toothache, neuralgia, sciatica, period pains and sore throats. Reduction of temperature in feverishness, influenza and colds. Reduction of inflammation in rheumatism and lumbago.",
            "olini Spray is a pain relief spray which provides fast relief from muscle pain, sprain and pain in the joints.",
            "Moov Ointment is made using 100% ayurvedic ingredients, which penetrate deep inside to produce the warmth",
            "Omnigel 30 gm contains Diclofenac and Methyl salicylate (as a pain killer), Linseed oil (as an anti-inflammatory), and Menthol (as a cooling agent)"
        )
        fees = arrayOf("108.53", "60.00", "160.00", "11.0", "59.50", "116", "72.60")
        for (i in imageId.indices) {
            val things = medicine_details(imageId[i], Name[i], speciality[i], fees[i])
            medicineDetails.add(things)
        }


    }
}