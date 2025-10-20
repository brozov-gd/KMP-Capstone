package com.example.capstone.data.database

import com.example.capstone.Constants
import com.example.capstone.db.UserDatabase

class SharedDatabase(private val databaseDriverFactory: DatabaseDriverFactory) {
    private var database: UserDatabase? = null

    private suspend fun initDatabase() {
        database.takeIf { it != null } ?: run {
            database = UserDatabase(databaseDriverFactory.createDriver())
        }
    }

    suspend operator fun <R> invoke(block: suspend (UserDatabase) -> R): R {
        initDatabase()
        return database.takeIf { it != null }?.let {
            block(it)
        } ?: error(Constants.DATABASE_NOT_INITIALIZED)
    }
}
