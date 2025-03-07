package com.nmichail.database.users

import com.nmichail.services.UserService
import org.koin.java.KoinJavaComponent.inject

class UserController {

    private val userService: UserService by inject()

    fun getUserById(id: Int): UserDTO? = userService.getUserById(id)

    fun getUserByPhoneNumber(phoneNumber: String): UserDTO? = userService.getUserByPhoneNumber(phoneNumber)

    fun addUser(user: UserDTO): Int = userService.addUser(user)
}