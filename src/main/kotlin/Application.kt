package com.nmichail

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    println("SYKA BLYAD")

    routing {
        get("/") {
            call.respondText("Hello, World! Сервер работает!")
        }
    }
}