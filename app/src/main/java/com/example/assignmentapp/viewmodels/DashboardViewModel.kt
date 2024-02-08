package com.example.assignmentapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentapp.model.Employee
import com.example.assignmentapp.repoistory.EmployeeRepository
import com.example.assignmentapp.repoistory.RealmHelper
import kotlinx.coroutines.launch

class DashboardViewModel:ViewModel() {
    private val realmHelper: RealmHelper = RealmHelper()
    private val employeeHelper:EmployeeRepository=EmployeeRepository()

    fun saveDataToRealmDb(name:String, age: String, city:String)
    {
        realmHelper.addPersonsToRealm(name,age,city)
    }

    fun insertEmployeeData(employee: Employee) {
        viewModelScope.launch {
            employeeHelper.insertEmployee(employee)
        }
    }
}