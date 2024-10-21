package com.example.reservadecitas203

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reservadecitas203.databinding.FragmentDoctorSelectionBinding

class DoctorSelectionFragment : Fragment() {
    private lateinit var binding: FragmentDoctorSelectionBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoctorSelectionBinding.inflate(inflater, container, false)

        val doctors = listOf(
            Doctor("Dr. Pedro Reynoso", "Cirujano Plastico", "Sabados y Domingos"),
            Doctor("Dra. Atza", "Cardiologia", "Lunes a Viernes"),
            Doctor("Dra. Atza", "Medico General", "Sabado a Domingo"),
            Doctor("Dr. Luis", "Medico General", "Lunes a Vierner"),
            Doctor("Dr. Ricardo", "Podologo", "Sabados y Domingos"),
            Doctor("Dra. Silvia", "Neumologo", "Martes a Domingos"),
            Doctor("Dr. Guillermo", "Quiropractico", "Jueves a Domingo"),
            Doctor("Dr. Armando", "Gastroenterologo", "Lunes a Miercoles"),
            Doctor("Dr. Altamirano", "Dermatologia", "Miercoles a Domingo"),
            Doctor("Dra. Veronica", "Pediatria", "Jueves"),

        )

        val adapter = DoctorAdapter(doctors) { doctor ->
            sharedViewModel.selectDoctor(doctor)
            (activity as MainActivity).navigateToAppointmentDetails()
        }

        binding.recyclerViewDoctors.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewDoctors.adapter = adapter

        return binding.root
    }
}