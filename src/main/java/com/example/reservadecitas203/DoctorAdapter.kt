package com.example.reservadecitas203

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class
DoctorAdapter(
    private val doctors: List<Doctor>,
    private val onDoctorSelected: (Doctor) -> Unit
) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctors[position]
        holder.bind(doctor)
        holder.itemView.setOnClickListener {
            onDoctorSelected(doctor)
        }
    }

    override fun getItemCount(): Int = doctors.size

    class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(android.R.id.text1)
        private val specialtyTextView: TextView = itemView.findViewById(android.R.id.text2)

        fun bind(doctor: Doctor) {
            nameTextView.text = doctor.name
            specialtyTextView.text = "${doctor.specialty} - ${doctor.availability}"
        }
    }
}
