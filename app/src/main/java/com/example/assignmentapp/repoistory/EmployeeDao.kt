package com.example.assignmentapp.repoistory

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.assignmentapp.model.Employee

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insertEmployee(users: Employee)

    @Query("Select * from user")
     fun gelAllEmployee(): List<Employee>

}