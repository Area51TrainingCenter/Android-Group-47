package com.area51.clasemvp

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

open class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val configuration = RealmConfiguration.Builder()
            .schemaVersion(1)
            .name("clase_mvp.realm")
            .build()
        Realm.setDefaultConfiguration(configuration)
    }
}