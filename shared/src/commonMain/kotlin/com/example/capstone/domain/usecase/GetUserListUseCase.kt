package com.example.capstone.domain.usecase

import com.example.capstone.domain.model.User

interface GetUserListUseCase {
    suspend fun execute(): List<User>
}