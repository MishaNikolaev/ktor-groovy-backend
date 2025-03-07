package com.nmichail.routes

import com.nmichail.models.Song
import com.nmichail.services.MusicService
import com.nmichail.utils.FileUtils
import io.ktor.http.*
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.request.receiveMultipart
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.io.File

fun Route.musicRoutes() {
    route("/audio") {
        get("/{filename}") {
            val filename = call.parameters["filename"] ?: throw IllegalArgumentException("Filename is missing")
            val audioFile = File("src/main/resources/$filename")

            if (audioFile.exists()) {
                call.response.header(HttpHeaders.ContentDisposition, "inline; filename=\"$filename\"")
                call.respondFile(audioFile)
            } else {
                call.respond(HttpStatusCode.NotFound, "Audio file not found")
            }
        }
    }
}