package com.nmichail.database.users

import org.jetbrains.exposed.sql.Table

object Users : Table("users") {
    val id = integer("user_id").autoIncrement()
    val phoneNumber = varchar("phone_number", 10).uniqueIndex()
    val password = varchar("password", 64)
    val salt = varchar("salt", 64)

    override val primaryKey = PrimaryKey(id)
}