package com.nmichail.utils


import io.ktor.http.content.*
import java.io.File

object FileUtils {
    const val UPLOAD_DIR = "uploads"

    fun saveFile(fileItem: PartData.FileItem, subDir: String): String {
        val uploadDir = File(UPLOAD_DIR, subDir).apply { mkdirs() }
        val file = File(uploadDir, fileItem.originalFileName!!)
        fileItem.streamProvider().use { input ->
            file.outputStream().buffered().use { output ->
                input.copyTo(output)
            }
        }
        return file.absolutePath
    }
}