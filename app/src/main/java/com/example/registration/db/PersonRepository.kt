package com.example.registration.db

class PersonRepository(private val dao: PersonDao) {
    val subscriber=dao.getAllPerson()
    
    suspend fun insert(person: Person){
        dao.insertPerson(person)
    }
    
    suspend fun update(person: Person){
        dao.updatePerson(person)
    }
    
    suspend fun delete(person: Person){
        dao.deletePerson(person)
    }
    
    suspend fun deleteAlll(){
        dao.deleteAll()
    }
}
