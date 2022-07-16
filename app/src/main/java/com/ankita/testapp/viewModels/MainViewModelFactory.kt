package com.ankita.testapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ankita.testapp.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory@Inject constructor(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }

}