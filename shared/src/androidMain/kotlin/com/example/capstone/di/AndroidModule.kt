package com.example.capstone.di

import com.example.capstone.data.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule =
    module {
        single {
            DatabaseDriverFactory(androidContext())
        }
    }
