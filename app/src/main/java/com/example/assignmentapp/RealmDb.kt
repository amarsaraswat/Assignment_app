package com.example.assignmentapp

import android.app.Application
import io.realm.Realm

import io.realm.RealmConfiguration

class RealmDb:Application() {
    override fun onCreate() {
        super.onCreate()
//        Realm.init(this)
//        val config = RealmConfiguration.Builder()
//            .name("database.realm")
//            .allowWritesOnUiThread(true)
//            .deleteRealmIfMigrationNeeded()
//            .build()
//        Realm.setDefaultConfiguration(config)
        
    }
}