package com.example.registration.model

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.db.Person
import com.example.registration.db.PersonRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PersonViewModel(private val repository: PersonRepository):ViewModel(), Observable {
    val subscriber = repository.subscriber
    
    fun insert(person: Person): Job = viewModelScope.launch {
        repository.insert(person)
    }

    fun update(person: Person): Job = viewModelScope.launch {
        repository.update(person)
    }

    fun delete(person: Person): Job = viewModelScope.launch {
        repository.delete(person)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        Log.e("abc","abc")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        Log.e("abc","abc")
    }
}
