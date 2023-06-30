package com.example.swasthyacare.pharmacy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swasthyacare.R

class medicineAdapter(private val medicinelist: ArrayList<medicine_details>) :RecyclerView.Adapter<medicineAdapter.MyViewHolder>() {

    private lateinit var myListner: onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listner: onItemClickListner){
        myListner = listner
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): medicineAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_doctor , parent ,false)
        return medicineAdapter.MyViewHolder(itemView, myListner)
    }

    override fun getItemCount(): Int {
        return medicinelist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = medicinelist[position]
        holder.tvname.text = currentItem.name
        holder.tvspeciality.text = currentItem.speciality
        holder.tvfees.text = "PRICE "+currentItem.fees
        holder.img.setImageResource(currentItem.image)

    }

    class MyViewHolder(itemView: View, listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {

        val tvname = itemView.findViewById<TextView>(R.id.name)
        val img =
            itemView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.profile_image)
        val tvspeciality = itemView.findViewById<TextView>(R.id.speciality)
        val tvfees = itemView.findViewById<TextView>(R.id.fees)

        init {
            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }
        }
    }
}
