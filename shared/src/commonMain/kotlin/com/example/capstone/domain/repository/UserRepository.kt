package com.example.capstone.domain.repository

import com.example.capstone.domain.model.User

interface UserRepository {
    suspend fun getUsers(forceRefresh: Boolean = false): List<User>
}