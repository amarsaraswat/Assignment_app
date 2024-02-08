package com.example.assignmentapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentapp.model.Employee
import com.example.assignmentapp.model.Person
import com.example.assignmentapp.repoistory.EmployeeRepository
import com.example.assignmentapp.repoistory.RealmHelper
import io.realm.Realm
import io.realm.Sort
import kotlinx.coroutines.launch

class PersonDataViewModel:ViewModel() {

    private val realmHelper:RealmHelper= RealmHelper()
    private val employeeHelper: EmployeeRepository = EmployeeRepository()
     fun fetchDataFromRealmDb(): List<Person> {

     return realmHelper.fetchPersonsByNameFromRealm()
     }


    fun getAllUsers(): List<Employee> {
        var list:List<Employee> = ArrayList()
        viewModelScope.launch {
             list = employeeHelper.getAllEmployee()
        }
        return list
    }


    override fun onCleared() {
        Realm.getDefaultInstance().close()
        super.onCleared()
    }
}