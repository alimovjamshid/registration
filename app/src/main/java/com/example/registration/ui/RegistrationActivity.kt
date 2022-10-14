package com.example.registration.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.registration.databinding.ActivityRegistrationBinding
import com.example.registration.db.Person
import com.example.registration.db.PersonDao
import com.example.registration.db.PersonDatabase
import com.example.registration.db.PersonRepository
import com.example.registration.model.PersonViewModel
import com.example.registration.model.PersonViewModelFactory

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var personViewModel: PersonViewModel
    private var img:Uri?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = PersonDatabase.getInstance(this)
        val dao: PersonDao = database.personDao
        val repository = PersonRepository(dao)
        val factory = PersonViewModelFactory(repository)
        personViewModel = ViewModelProvider(this, factory)[PersonViewModel::class.java]
        binding.mySecondViewModel = personViewModel
        binding.lifecycleOwner = this

        binding.image.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        binding.add.setOnClickListener {
            personViewModel.insert(
                Person(
                    name = binding.fullName.text.toString(),
                    number = binding.phoneNumber.text.toString(),
                    country = binding.coutry.text.toString(),
                    addres = binding.addres.text.toString(),
                    parol = binding.parol.text.toString(),
                    image = img!!
                )
            )
            startActivity(Intent(this,ListActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode ==100){
            img=data?.data
            binding.image.setImageURI(img)
        }
    }
}
