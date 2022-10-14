package com.example.registration.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registration.R
import com.example.registration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.newRegistration.setOnClickListener { 
            val intent=Intent(applicationContext,RegistrationActivity::class.java)
            startActivity(intent)
        }
        
    }
}
