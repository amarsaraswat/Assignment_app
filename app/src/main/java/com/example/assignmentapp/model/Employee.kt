package com.example.assignmentapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class Employee
    (@PrimaryKey(autoGenerate = true)
     val name: String,
     var age: Int? = null,
     var city: String,

     )