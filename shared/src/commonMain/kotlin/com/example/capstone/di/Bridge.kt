package com.example.capstone.di

import com.example.capstone.domain.usecase.GetUserListUseCase

suspend fun getUserListUseCase(): GetUserListUseCase = getKoin().get()