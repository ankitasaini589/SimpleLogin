package com.ankita.testapp.di

import androidx.appcompat.app.AppCompatActivity
import com.ankita.testapp.LoginActivity
import com.ankita.testapp.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent  {
    fun inject(loginActivity : LoginActivity)
}