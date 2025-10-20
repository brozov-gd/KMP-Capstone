package com.example.capstone.data.repository

import com.example.capstone.data.database.datasource.LocalUserDataSource
import com.example.capstone.data.mapper.toDomain
import com.example.capstone.data.network.datasource.RemoteUserDataSource
import com.example.capstone.domain.model.User
import com.example.capstone.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remote: RemoteUserDataSource,
    private val local: LocalUserDataSource
) : UserRepository {
    override suspend fun getUsers(forceRefresh: Boolean): List<User> {
        val cached = local.getUsers()
        if (cached.isNotEmpty() && !forceRefresh) return cached
        val fresh = remote.fetchUsers().map { it.toDomain() }
        local.replaceAll(fresh)
        return fresh
    }
}