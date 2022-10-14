package com.example.registration.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registration.adapter.Adapter
import com.example.registration.databinding.ActivityListBinding
import com.example.registration.db.Person
import com.example.registration.db.PersonDao
import com.example.registration.db.PersonDatabase
import com.example.registration.db.PersonRepository
import com.example.registration.model.PersonViewModel
import com.example.registration.model.PersonViewModelFactory

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var personViewModel: PersonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val database = PersonDatabase.getInstance(this)
        val dao:PersonDao = database.personDao
        val repository = PersonRepository(dao)
        val factory = PersonViewModelFactory(repository)
        personViewModel = ViewModelProvider(this,factory)[PersonViewModel::class.java]
        binding.myViewModel=personViewModel
        binding.lifecycleOwner=this
        initRecycleView()
    }
    private fun initRecycleView(){
        binding.list.layoutManager = LinearLayoutManager(this)
        displayPersonList()
    }
    private fun displayPersonList(){
        personViewModel.subscriber.observe(this) {
            Log.i("MYTAG", it.toString())
            binding.list.adapter = Adapter(it)
        }
    }
}
