package com.nmichail

import com.nmichail.routes.musicRoutes
import com.nmichail.routes.uploadMusicRoute
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        musicRoutes()
        uploadMusicRoute()

        get("/") {
            call.respondText("Music server is running!")
        }
    }
}
