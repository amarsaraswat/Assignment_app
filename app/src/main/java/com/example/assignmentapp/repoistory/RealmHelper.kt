package com.example.assignmentapp.repoistory

import com.example.assignmentapp.model.Person
import io.realm.Realm

class RealmHelper {

    fun addPersonsToRealm(name:String, age: String, city:String) {
        val realmObj = Realm.getDefaultInstance()
        val person = Person()
        person.name=name
        person.age=age
        person.city=city
        realmObj.executeTransaction { realm ->

            realm.copyToRealm(person)
        }
    }

    fun fetchPersonsByNameFromRealm(): List<Person> {
        val realm = Realm.getDefaultInstance()
        return realm.where(Person::class.java).findAll()

    }
}