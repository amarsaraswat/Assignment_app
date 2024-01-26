package com.example.assignmentapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.assignmentapp.repoistory.RealmHelper

class DashboardViewModel:ViewModel() {
    private val realmHelper: RealmHelper = RealmHelper()

    fun saveDataToRealmDb(name:String, age: String, city:String)
    {
        realmHelper.addPersonsToRealm(name,age,city)
    }
}