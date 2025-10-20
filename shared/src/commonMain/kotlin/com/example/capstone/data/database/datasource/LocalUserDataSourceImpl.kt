package com.example.capstone.data.database.datasource

import app.cash.sqldelight.async.coroutines.awaitAsList
import com.example.capstone.domain.model.User
import com.example.capstone.data.database.SharedDatabase
import com.example.capstone.data.mapper.toDomain
import com.example.capstone.data.mapper.toEntity

class LocalUserDataSourceImpl(private val db: SharedDatabase) : LocalUserDataSource {
    override suspend fun getUsers(): List<User> = db { database ->
        database.userDatabaseQueries
            .selectAll()
            .awaitAsList()
            .map {
                it.toDomain()
            }
    }

    override suspend fun replaceAll(users: List<User>) = db { database ->
        val q = database.userDatabaseQueries
        q.transaction {
            q.deleteAll()
            users.forEach { user ->
                val entity = user.toEntity()
                q.insertUser(
                    id = entity.id,
                    name = entity.name,
                    username = entity.username,
                    email = entity.email,
                    phone = entity.phone,
                    website = entity.website,
                )
            }
        }
    }
}