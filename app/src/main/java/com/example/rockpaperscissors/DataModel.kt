package com.example.rockpaperscissors

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

class DataModel  : RealmObject() {
    @PrimaryKey
    var _id: String?= null
    @Required
    //var title: String = ""
    var value: String? = null

}