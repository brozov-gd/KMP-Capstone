package com.example.capstone.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RemoteUser(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
)