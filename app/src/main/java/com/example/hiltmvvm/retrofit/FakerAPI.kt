package com.example.hiltmvvm.retrofit

import com.example.hiltmvvm.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}