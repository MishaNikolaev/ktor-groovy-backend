package com.nmichail.services

import com.nmichail.database.users.UserDTO
import com.nmichail.repositories.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun getUserById(id: Int): UserDTO? = userRepository.getUserById(id)

    fun getUserByPhoneNumber(phoneNumber: String): UserDTO? = userRepository.getUserByPhoneNumber(phoneNumber)

    fun addUser(user: UserDTO): Int = userRepository.addUser(user)
}
