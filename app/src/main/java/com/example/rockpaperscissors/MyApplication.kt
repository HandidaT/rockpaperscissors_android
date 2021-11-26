package com.example.rockpaperscissors

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val realmName: String = "RockPaperScissor"
        val config = RealmConfiguration.Builder()//Database initialization
            .name(realmName)
            .deleteRealmIfMigrationNeeded()
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(config)

    }
}