package com.example.assignmentapp.repoistory

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignmentapp.model.Employee

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDataBase :RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {

        private var INSTANCE: EmployeeDataBase? = null
        fun getDatabaseInstance(context: Context): EmployeeDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDataBase::class.java,
                    "user_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}