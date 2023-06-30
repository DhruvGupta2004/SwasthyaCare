package com.example.swasthyacare.lab.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swasthyacare.R
import de.hdodenhof.circleimageview.CircleImageView

class LabAdapter(private val Lablist: ArrayList<User>) :
    RecyclerView.Adapter<LabAdapter.MyViewHolder>() {

    private lateinit var myListner: onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listner: onItemClickListner){
        myListner = listner
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_doctor , parent ,false)
        return MyViewHolder(itemView, myListner)
    }

    override fun getItemCount(): Int {
        return Lablist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = Lablist[position]
        holder.tvname.text = currentItem.name
        holder.tvspeciality.text = currentItem.speciality
        holder.tvfees.text = "PRICE "+currentItem.fees
        holder.img.setImageResource(currentItem.image)

    }

    class MyViewHolder(itemView: View, listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {

        val tvname = itemView.findViewById<TextView>(R.id.name)
        val img = itemView.findViewById<CircleImageView>(R.id.profile_image)
        val tvspeciality = itemView.findViewById<TextView>(R.id.speciality)
        val tvfees = itemView.findViewById<TextView>(R.id.fees)

        init {
            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }
        }
    }
}
