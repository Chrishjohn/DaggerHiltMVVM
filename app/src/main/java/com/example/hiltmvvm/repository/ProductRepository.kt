package com.example.hiltmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltmvvm.db.DaggerDatabase
import com.example.hiltmvvm.models.Product
import com.example.hiltmvvm.retrofit.FakerAPI
import javax.inject.Inject

//dagger will fetch faker api object based on dagger and call faker api for getting fakker api products
class ProductRepository @Inject constructor(val fakerAPI: FakerAPI, val daggerDatabase: DaggerDatabase) {
private val _products=MutableLiveData<List<Product>>()
    val product:LiveData<List<Product>>
       //getting product live data
        get() =_products

    //getting products
    suspend fun getProducts()
    {
        val result=fakerAPI.getProducts()
        if (result.isSuccessful&&result.body()!=null)
        {
            //add product ada in to room database
            daggerDatabase.getDaggerDAO().addProducts(result.body()!!)

            //add product in postvlue live data
            _products.postValue(result.body())
        }
    }
}