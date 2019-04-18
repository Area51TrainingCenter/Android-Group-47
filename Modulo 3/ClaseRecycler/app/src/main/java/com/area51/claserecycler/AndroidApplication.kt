package com.area51.claserecycler

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .schemaVersion(1)
            .name("clase.realm")
            .build()
        Realm.setDefaultConfiguration(config)
    }
}