package com.nmichail.services

import com.nmichail.database.users.UserDTO
import com.nmichail.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UserService : KoinComponent {
    private val userRepository: UserRepository by inject()

    fun getUserById(id: Int): UserDTO? = userRepository.getUserById(id)

    fun getUserByPhoneNumber(phoneNumber: String): UserDTO? = userRepository.getUserByPhoneNumber(phoneNumber)

    fun addUser(user: UserDTO): Int = userRepository.addUser(user)
}