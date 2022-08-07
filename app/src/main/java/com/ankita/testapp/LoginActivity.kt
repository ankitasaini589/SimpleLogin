package com.ankita.testapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ankita.testapp.activity.DashBoardActivity
import com.ankita.testapp.viewModels.LoginViewModel
import com.ankita.testapp.viewModels.MainViewModelFactory
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val TAG = "LoginActivity "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val editTextPhone = findViewById<EditText>(R.id.editTextPhoneNumber)
        val editTextPassword = findViewById<EditText>(R.id.editTextNumberPassword)
        (application as TestApplication).appComponent.inject(this)

        val arrayList = ArrayList<Int>()
        arrayList.contains(1)
        val loginViewModel =
            ViewModelProvider(this, mainViewModelFactory)[LoginViewModel::class.java]
        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            loginViewModel.getLoginStatus(
                editTextPhone.text.toString(),
                editTextPassword.text.toString()
            )
        }

        loginViewModel._loginStatus.observe(this, Observer {
            print(TAG + it.joinToString { x -> x.title + "\n\n" })
            val data = loginViewModel._loginStatus.value
            val intentDashBoardActivity = Intent(this, DashBoardActivity::class.java)
            startActivity(intentDashBoardActivity)
        })
    }
}