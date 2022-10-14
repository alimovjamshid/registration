package com.example.registration.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.R
import com.example.registration.databinding.ListItemBinding
import com.example.registration.db.Person

class Adapter(private val list: List<Person>) : RecyclerView.Adapter<MyViewHolder>() {
    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater:LayoutInflater=LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(layoutInflater,parent.findViewById(R.layout.list_item),false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class MyViewHolder(private val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(person: Person){
        binding.imgPerson.setImageResource(person.image)
        binding.listName.text = person.name
        binding.listNumber.text = person.number
    }
}
