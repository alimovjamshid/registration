package com.example.registration.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase :RoomDatabase(){
    abstract val personDao:PersonDao
    
    companion object{
        @Volatile
        private var INSTANCE:PersonDatabase?=null
        
        fun getInstance(context: Context):PersonDatabase{
            synchronized(this){
                var instance:PersonDatabase ?= INSTANCE
                if(instance == null){
                    instance=Room.databaseBuilder(
                        context,PersonDatabase::class.java,
                        "person_data_database"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}
