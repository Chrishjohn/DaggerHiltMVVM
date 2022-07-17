package com.example.hiltmvvm.di


import com.example.hiltmvvm.retrofit.FakerAPI
import com.example.hiltmvvm.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
//creating network module for accessing retrofit object and faker api object
@Module
class NetworkModule {
    //singleton for making single object refernce through out application
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideFactoryApi(retrofit: Retrofit): FakerAPI
    {
        return retrofit.create(FakerAPI::class.java)
    }
}
