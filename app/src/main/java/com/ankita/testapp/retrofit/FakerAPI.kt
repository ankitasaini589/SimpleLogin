package com.ankita.testapp.retrofit

import com.ankita.testapp.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {
    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}