package com.example.reservadecitas203

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.reservadecitas203.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {
    private lateinit var binding: FragmentConfirmationBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false)

        sharedViewModel.selectedDoctor.observe(viewLifecycleOwner) { doctor ->
            binding.textViewDoctorName.text = doctor?.name
            binding.textViewDoctorSpecialty.text = doctor?.specialty
        }

        sharedViewModel.appointmentDate.observe(viewLifecycleOwner) { date ->
            binding.textViewAppointmentDate.text = date
        }

        sharedViewModel.appointmentTime.observe(viewLifecycleOwner) { time ->
            binding.textViewAppointmentTime.text = time
        }

        binding.buttonConfirm.setOnClickListener {
            Toast.makeText(context, "Cita confirmada con éxito", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}