package com.nmichail.routes

import com.nmichail.models.Song
import com.nmichail.repositories.SongRepository
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
/*
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
}*/

fun Route.musicRoutes() {
    val songController by inject<SongRepository>()

    route("/songs") {
        get {
            val songs = songController.getAllSongs()
            call.respond(songs)
        }

        get("/{id}") {
            val id = call.parameters["id"] ?: throw IllegalArgumentException("Missing ID")
            val song = songController.getSongById(id)
            if (song != null) {
                call.respond(song)
            } else {
                call.respond(HttpStatusCode.NotFound, "Song not found")
            }
        }

        post {
            val song = call.receive<Song>()
            val songId = songController.addSong(song)
            call.respond(HttpStatusCode.Created, mapOf("id" to songId))
        }
    }
}

fun Route.fileRoutes() {
    route("/files") {
        get("/{filename}") {
            val filename = call.parameters["filename"] ?: throw IllegalArgumentException("Filename is missing")
            val file = File("src/main/resources/$filename")

            if (file.exists()) {
                call.response.header(HttpHeaders.ContentDisposition, "inline; filename=\"$filename\"")
                call.respondFile(file)
            } else {
                call.respond(HttpStatusCode.NotFound, "File not found")
            }
        }
    }
}