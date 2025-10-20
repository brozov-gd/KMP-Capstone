package com.example.capstone.domain.usecase

import com.example.capstone.domain.model.User
import com.example.capstone.domain.repository.UserRepository

class GetUserListUseCaseImpl(private val repository: UserRepository): GetUserListUseCase {
    override suspend fun execute(): List<User> = repository.getUsers(false)
}