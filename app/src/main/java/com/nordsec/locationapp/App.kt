package com.nordsec.locationapp

import android.app.Application
import android.content.Context
import com.nordsec.locationapp.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        currentApplication = this
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(koinModules)
        }
    }

    companion object {
        private var currentApplication: Application? = null
        private val application: Application?
            get() = currentApplication
        val context: Context
            get() = application!!.applicationContext
    }
}