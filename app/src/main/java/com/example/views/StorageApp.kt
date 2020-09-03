package com.example.views

import android.app.Application

class StorageApp:Application() {

    val db:AppDb by lazy {
        AppDb.getDatabase(this)
    }
    override fun onCreate() {
        super.onCreate()
    }
}