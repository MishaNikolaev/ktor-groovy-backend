package com.nmichail.config

import com.nmichail.database.music.Musics
import com.nmichail.database.users.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseConfig {
    fun init() {
        Database.connect(
            url = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/musicdb",
            driver = "org.postgresql.Driver",
            user = System.getenv("DB_USER") ?: "nmichail",
            password = System.getenv("DB_PASSWORD") ?: "firamir123"
        )

        transaction {
            SchemaUtils.create(Users, Musics)
        }
    }
}