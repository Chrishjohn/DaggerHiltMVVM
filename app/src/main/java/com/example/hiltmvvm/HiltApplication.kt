package com.example.hiltmvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//application
@HiltAndroidApp
class HiltApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}