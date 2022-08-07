package com.ankita.testapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ankita.testapp.models.Product
import com.ankita.testapp.retrofit.FakerAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class ProductRepository  @Inject constructor(private val fakerAPI: FakerAPI){

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
    get() = _products

    suspend fun getProducts(){
        withContext(Dispatchers.IO){
            val result = fakerAPI.getProducts()
            if(result.isSuccessful && result.body() != null){
                //fakerDB.getFakerDAO().addProducts(result.body()!!)
                _products.postValue(result.body())
            }
        }
    }
}