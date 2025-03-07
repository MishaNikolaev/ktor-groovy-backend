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
    val musicService by inject<MusicService>()

    route("/songs") {
        get {
            val songs = musicService.getAllSongs()
            call.respond(songs)
        }

        get("/{id}") {
            val id = call.parameters["id"] ?: throw IllegalArgumentException("Missing ID")
            val song = musicService.getSongById(id)
            if (song != null) {
                call.respond(song)
            } else {
                call.respond(HttpStatusCode.NotFound, "Song not found")
            }
        }

        post {
            val song = call.receive<Song>()
            val songId = musicService.addSong(song)
            call.respond(HttpStatusCode.Created, mapOf("id" to songId))
        }
    }
}