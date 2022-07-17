package com.example.hiltmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hiltmvvm.models.Product

@Dao
interface DaggerDAO {
    @Insert
   suspend fun addProducts(product: List<Product>)

    @Query("select * from Product")
 suspend   fun getProducts(): List<Product>
}