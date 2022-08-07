package com.ankita.testapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ankita.testapp.R
import com.ankita.testapp.TestApplication
import com.ankita.testapp.viewModels.LoginViewModel
import com.ankita.testapp.viewModels.MainViewModelFactory
import javax.inject.Inject

class DashBoardActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        (application as TestApplication).appComponent.inject(this)
        val loginViewModel =
            ViewModelProvider(this, mainViewModelFactory)[LoginViewModel::class.java]

        val data = loginViewModel._loginStatus.value
    }
}