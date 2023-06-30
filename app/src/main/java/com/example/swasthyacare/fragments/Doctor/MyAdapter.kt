package com.example.swasthyacare.fragments.Doctor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swasthyacare.R

class MyAdapter(var information: ArrayList<Details>, itemView: Any):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListner: onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listner: onItemClickListner){
        myListner = listner
    }


    // IF LAYOUT MANAGER FAILES TO LOAD VIEW
    //THEN ITS ASK TO THIS METHOD TO CREATE VIEWS
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_doctor , parent ,false)
        return MyViewHolder(itemView , myListner)

    }

    // TO POPULATE DATA IN VIEWS
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = information[position]
        holder.tvname.text = currentItem.name
        holder.tvspeciality.text = currentItem.speciality
        holder.tvfees.text = "Fees "+currentItem.fees
        holder.img.setImageResource(currentItem.image)
    }


    // NUMBER OF ITEM
    override fun getItemCount(): Int {
        return information.size
    }


    // IT HOLD THE VIEW SO VIES ARE NOT CREATE EVERY TIME , SO MEMORY CAN BE SAVED
    class MyViewHolder(itemView : View , listner: onItemClickListner) : RecyclerView.ViewHolder(itemView){

        val tvname = itemView.findViewById<TextView>(R.id.name)
        val img = itemView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.profile_image)
        val tvspeciality = itemView.findViewById<TextView>(R.id.speciality)
        val tvfees = itemView.findViewById<TextView>(R.id.fees)

        init {
            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }
        }

    }

}