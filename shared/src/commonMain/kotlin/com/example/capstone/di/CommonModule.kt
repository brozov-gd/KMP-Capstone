package com.example.capstone.di

import com.example.capstone.data.database.SharedDatabase
import com.example.capstone.data.database.datasource.LocalUserDataSource
import com.example.capstone.data.database.datasource.LocalUserDataSourceImpl
import com.example.capstone.data.network.datasource.RemoteUserDataSource
import com.example.capstone.data.network.datasource.RemoteUserDataSourceImpl
import com.example.capstone.data.repository.UserRepositoryImpl
import com.example.capstone.domain.repository.UserRepository
import com.example.capstone.domain.usecase.GetUserListUseCase
import com.example.capstone.domain.usecase.GetUserListUseCaseImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val commonModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
    single<RemoteUserDataSource> { RemoteUserDataSourceImpl(get()) }
    single {
        SharedDatabase(get())
    }
    single<LocalUserDataSource> { LocalUserDataSourceImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<GetUserListUseCase> { GetUserListUseCaseImpl(get()) }
}