package com.example.capstone.data.network.datasource

import com.example.capstone.data.network.model.RemoteUser

interface RemoteUserDataSource {
    suspend fun fetchUsers(): List<RemoteUser>
}