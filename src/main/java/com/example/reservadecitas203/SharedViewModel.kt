package com.example.reservadecitas203

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Doctor(val name: String, val specialty: String, val availability: String)

class SharedViewModel : ViewModel() {
    private val _selectedDoctor = MutableLiveData<Doctor?>()
    val selectedDoctor: LiveData<Doctor?> get() = _selectedDoctor

    private val _appointmentDate = MutableLiveData<String?>()
    val appointmentDate: LiveData<String?> get() = _appointmentDate

    private val _appointmentTime = MutableLiveData<String?>()
    val appointmentTime: LiveData<String?> get() = _appointmentTime

    fun selectDoctor(doctor: Doctor) {
        _selectedDoctor.value = doctor
    }

    fun setAppointmentDate(date: String) {
        _appointmentDate.value = date
    }

    fun setAppointmentTime(time: String) {
        _appointmentTime.value = time
    }
}