package com.example.capstone.data.database.datasource

import com.example.capstone.domain.model.User

interface LocalUserDataSource {
    suspend fun getUsers(): List<User>
    suspend fun replaceAll(users: List<User>)
}