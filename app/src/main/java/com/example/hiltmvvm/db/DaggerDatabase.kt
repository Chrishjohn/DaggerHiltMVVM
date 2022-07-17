package com.example.hiltmvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltmvvm.db.DaggerDAO
import com.example.hiltmvvm.models.Product

@Database(entities = [Product::class], version = 1)
abstract class DaggerDatabase: RoomDatabase() {
abstract fun getDaggerDAO(): DaggerDAO
}