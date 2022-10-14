package com.example.registration.db

import android.content.res.Resources
import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_data_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    val id:Int=0,

    @ColumnInfo(name = "person_name")
    val name: String,

    @ColumnInfo(name = "person_parol")
    val parol:String,

    @ColumnInfo(name = "person_number")
    val number:String,

    @ColumnInfo(name = "person_country")
    val country:String,

    @ColumnInfo(name = "person_addres")
    val addres:String,

    @ColumnInfo(name = "person_image")
    val image: Uri
)
