package com.ankita.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextPhone = findViewById<EditText>(R.id.editTextPhoneNumber)
        val editTextPassword = findViewById<EditText>(R.id.editTextNumberPassword)
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            loginViewModel.getLoginStatus(
                editTextPhone.text.toString(),
                editTextPassword.text.toString()
            ).observe(this, Observer {
                Toast.makeText(this, "Login successfully!!!", Toast.LENGTH_LONG).show()
            })
        }
    }
}