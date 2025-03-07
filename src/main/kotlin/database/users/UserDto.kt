package com.nmichail.database.users

data class UserDTO(
    val id: Int = 0,
    val phoneNumber: String,
    val password: String,
    val salt: String
)