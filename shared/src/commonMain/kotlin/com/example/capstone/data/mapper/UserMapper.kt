package com.example.capstone.data.mapper

import com.example.capstone.UserEntity
import com.example.capstone.data.network.model.RemoteUser
import com.example.capstone.domain.model.User

fun RemoteUser.toDomain() = User(
    id = id,
    name = name,
    username = username,
    email = email,
    phone = phone,
    website = website
)

fun UserEntity.toDomain() = User(
    id = id.toInt(),
    name = name,
    username = username,
    email = email,
    phone = phone,
    website = website
)

fun User.toEntity() = UserEntity(
    id = id.toLong(),
    name = name,
    username = username,
    email = email,
    phone = phone,
    website = website
)