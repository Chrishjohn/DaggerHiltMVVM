package com.example.hiltmvvm.di

import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import com.example.hiltmvvm.db.DaggerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    //creating the instance of room database
    @Singleton
    @Provides
    fun provideDaggerDB(@ApplicationContext context:Context): DaggerDatabase {
        return Room.databaseBuilder(context, DaggerDatabase::class.java, "DaggerDB").build()
    }
}