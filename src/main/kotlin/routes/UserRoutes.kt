package com.nmichail.routes

import com.nmichail.database.users.UserController
import com.nmichail.database.users.UserDTO
import com.nmichail.services.UserService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
/*
fun Route.userRoutes() {
    val userService by inject<UserService>()

    route("/users") {
        post {
            val user = call.receive<UserDTO>()
            val userId = userService.addUser(user)
            call.respond(HttpStatusCode.Created, mapOf("id" to userId))
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Missing ID")
            val user = userService.getUserById(id)
            if (user != null) {
                call.respond(user)
            } else {
                call.respond(HttpStatusCode.NotFound, "User not found")
            }
        }
    }
}
 */

fun Route.userRoutes() {
    val userController by inject<UserController>()

    route("/users") {
        post {
            val user = call.receive<UserDTO>()
            val userId = userController.addUser(user)
            call.respond(HttpStatusCode.Created, mapOf("id" to userId))
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Missing ID")
            val user = userController.getUserById(id)
            if (user != null) {
                call.respond(user)
            } else {
                call.respond(HttpStatusCode.NotFound, "User not found")
            }
        }
    }
}