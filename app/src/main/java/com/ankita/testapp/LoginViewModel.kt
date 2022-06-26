package com.ankita.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val loginStatus: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun getLoginStatus(phoneNumber: String, password: String): LiveData<Boolean> {
        loginStatus.value = true
        return loginStatus
    }
}