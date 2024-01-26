package com.example.assignmentapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.assignmentapp.model.Person
import com.example.assignmentapp.repoistory.RealmHelper
import io.realm.Realm
import io.realm.Sort

class PersonDataViewModel:ViewModel() {

    private val realmHelper:RealmHelper= RealmHelper()

     fun fetchDataFromRealmDb(): List<Person> {

     return realmHelper.fetchPersonsByNameFromRealm()
     }


    override fun onCleared() {
        Realm.getDefaultInstance().close()
        super.onCleared()
    }
}