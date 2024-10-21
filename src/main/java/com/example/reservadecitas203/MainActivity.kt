package com.example.reservadecitas203

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.reservadecitas203.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Último Intento"


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragmentContainerView, DoctorSelectionFragment())
            }
        }
    }

    fun navigateToAppointmentDetails() {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, AppointmentDetailsFragment())
            addToBackStack(null)
        }
    }

    fun navigateToConfirmation() {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, ConfirmationFragment())
            addToBackStack(null)
        }
    }
}
