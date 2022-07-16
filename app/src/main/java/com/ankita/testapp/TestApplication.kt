package com.ankita.testapp

import android.app.Application
import com.ankita.testapp.di.ApplicationComponent
import com.ankita.testapp.di.DaggerApplicationComponent

class TestApplication : Application() {
    lateinit var appComponent : ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().build()
    }
}