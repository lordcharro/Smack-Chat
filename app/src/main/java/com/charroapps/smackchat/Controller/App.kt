package com.charroapps.smackchat.Controller

import android.app.Application
import com.charroapps.smackchat.Utilities.SharedPrefs

// Share the SharedPreferences across the all application
class App : Application() {

    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}