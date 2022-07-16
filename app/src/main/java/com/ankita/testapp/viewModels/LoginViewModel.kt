package com.ankita.testapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankita.testapp.models.Product
import com.ankita.testapp.repository.ProductRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    val _loginStatus: LiveData<List<Product>>
        get() = productRepository.products

    fun getLoginStatus(phoneNumber: String, password: String) {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }

}