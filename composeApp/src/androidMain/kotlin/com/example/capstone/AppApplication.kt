package com.example.capstone

import android.app.Application
import com.example.capstone.di.initKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}