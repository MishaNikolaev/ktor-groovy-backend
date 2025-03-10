package com.nmichail.repositories

import com.nmichail.database.users.UserDTO
import com.nmichail.database.users.Users
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

/*
class UserRepository {

    fun getUserById(id: Int): UserDTO? = transaction {
        Users.selectAll()
            .andWhere { Users.id eq id }
            .singleOrNull()
            ?.let {
                UserDTO(
                    id = it[Users.id],
                    phoneNumber = it[Users.phoneNumber],
                    password = it[Users.password],
                    salt = it[Users.salt]
                )
            }
    }

    fun getUserByPhoneNumber(phoneNumber: String): UserDTO? = transaction {
        Users.selectAll()
            .andWhere { Users.phoneNumber eq phoneNumber }
            .singleOrNull()
            ?.let {
                UserDTO(
                    id = it[Users.id],
                    phoneNumber = it[Users.phoneNumber],
                    password = it[Users.password],
                    salt = it[Users.salt]
                )
            }
    }

    fun addUser(user: UserDTO): Int = transaction {
        Users.insert {
            it[phoneNumber] = user.phoneNumber
            it[password] = user.password
            it[salt] = user.salt
        }[Users.id]
    }
}

 */

interface UserRepository {
    fun getUserById(id: Int): UserDTO?
    fun getUserByPhoneNumber(phoneNumber: String): UserDTO?
    fun addUser(user: UserDTO): Int
}
