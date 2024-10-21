package com.example.reservadecitas203

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.reservadecitas203.databinding.FragmentAppointmentDetailsBinding

class AppointmentDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAppointmentDetailsBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppointmentDetailsBinding.inflate(inflater, container, false)


        val selectedDoctor = sharedViewModel.selectedDoctor.value
        binding.textViewDoctorName.text = selectedDoctor?.name
        binding.textViewDoctorSpecialty.text = selectedDoctor?.specialty

        binding.buttonContinue.setOnClickListener {

            val dia = binding.datePicker.dayOfMonth
            val mes = binding.datePicker.month
            val año = binding.datePicker.year
            val selectedDate = "$dia/${mes + 1}/$año"


            val hora = binding.timePicker.hour
            val minuto = binding.timePicker.minute
            val selectedTime = String.format("%02d:%02d", hora, minuto)


            sharedViewModel.setAppointmentDate(selectedDate)
            sharedViewModel.setAppointmentTime(selectedTime)


            (activity as MainActivity).navigateToConfirmation()
        }

        return binding.root
    }
}
