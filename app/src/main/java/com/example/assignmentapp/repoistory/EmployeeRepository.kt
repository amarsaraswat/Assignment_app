package com.example.assignmentapp.repoistory

import com.example.assignmentapp.model.Employee

class EmployeeRepository (){

    private lateinit var  userDao: EmployeeDao

    suspend fun insertEmployee(user: Employee){
        userDao.insertEmployee(user)
    }

    suspend fun getAllEmployee(): List<Employee>{
        return userDao.gelAllEmployee()
    }




}