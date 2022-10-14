package com.example.registration.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.registration.db.PersonRepository

class PersonViewModelFactory(private val repository: PersonRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
            return PersonViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Unknown View Model Class")
    }
}
