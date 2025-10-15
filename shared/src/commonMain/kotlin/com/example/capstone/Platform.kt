package com.example.capstone

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform