package com.example.registration.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: com.example.registration.db.Person)
    
    @Update
    suspend fun updatePerson(person: Person)
    
    @Delete
    suspend fun deletePerson(person: Person)
    
    @Query("Delete FROM person_data_table")
    suspend fun deleteAll()
    
    @Query("SELECT * FROM person_data_table")
    fun getAllPerson():LiveData<List<Person>>
}
