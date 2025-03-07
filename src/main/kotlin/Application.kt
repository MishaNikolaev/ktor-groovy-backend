package com.nmichail

import com.nmichail.config.DatabaseConfig
import com.nmichail.routes.musicRoutes
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.nmichail.config.appModule
import com.nmichail.routes.fileRoutes
import com.nmichail.routes.userRoutes
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080) {
        install(Koin) {
            modules(appModule)
        }
        DatabaseConfig.init()
        module()
    }.start(wait = true)
}

fun Application.module() {
    routing {
        musicRoutes()
        userRoutes()
        fileRoutes()
    }
}