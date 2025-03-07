package com.nmichail.routes

import com.nmichail.models.Song
import com.nmichail.services.MusicService
import com.nmichail.utils.FileUtils
import io.ktor.http.*
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.application.*
import io.ktor.server.request.receiveMultipart
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.io.File

fun Route.musicRoutes() {
    val musicService = MusicService()

    route("/music") {
        // Получить список всех загруженных треков
        get {
            call.respond(musicService.getAllTracks())
        }

        // Скачать конкретный трек
        get("/{filename}") {
            val filename = call.parameters["filename"]
            val file = File("uploads/audio/$filename")

            if (file.exists()) {
                call.response.header(
                    HttpHeaders.ContentDisposition,
                    ContentDisposition.Attachment.withParameter(ContentDisposition.Parameters.FileName, filename!!).toString()
                )
                call.respondFile(file)
            } else {
                call.respond(HttpStatusCode.NotFound, "Файл не найден")
            }
        }
    }
}

fun Route.uploadMusicRoute() {
    post("/upload") {
        val multipart = call.receiveMultipart()
        var uploadedFilePath: String? = null

        multipart.forEachPart { part ->
            if (part is PartData.FileItem) {
                uploadedFilePath = FileUtils.saveFile(part)
            }
            part.dispose()
        }

        if (uploadedFilePath != null) {
            call.respond(HttpStatusCode.OK, "Файл загружен: $uploadedFilePath")
        } else {
            call.respond(HttpStatusCode.BadRequest, "Ошибка загрузки файла")
        }
    }
}