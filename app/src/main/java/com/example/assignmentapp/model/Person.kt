package com.example.assignmentapp.model

import io.realm.RealmObject

open class Person : RealmObject() {
    var name: String? = null
    var age: String? = null
    var city: String? = null
}

