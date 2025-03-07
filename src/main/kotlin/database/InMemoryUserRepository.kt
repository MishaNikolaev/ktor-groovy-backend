package com.nmichail.database

import com.nmichail.database.users.UserDTO
import com.nmichail.repositories.UserRepository
import java.util.concurrent.atomic.AtomicInteger

class InMemoryUserRepository : UserRepository {
    private val users = mutableListOf<UserDTO>()
    private val idCounter = AtomicInteger(1)

    override fun getUserById(id: Int): UserDTO? = users.find { it.id == id }

    override fun getUserByPhoneNumber(phoneNumber: String): UserDTO? =
        users.find { it.phoneNumber == phoneNumber }

    override fun addUser(user: UserDTO): Int {
        val newUser = user.copy(id = idCounter.getAndIncrement())
        users.add(newUser)
        return newUser.id
    }
}