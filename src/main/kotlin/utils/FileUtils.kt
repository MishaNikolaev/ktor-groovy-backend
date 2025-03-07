package com.nmichail.utils


import io.ktor.http.content.*
import java.io.File


object FileUtils {
    private const val UPLOAD_DIR = "uploads/audio"

    init {
        File(UPLOAD_DIR).mkdirs()
    }

    fun saveFile(fileItem: PartData.FileItem): String {
        val fileName = fileItem.originalFileName ?: return ""
        val file = File(UPLOAD_DIR, fileName)

        fileItem.streamProvider().use { input ->
            file.outputStream().buffered().use { output ->
                input.copyTo(output)
            }
        }

        return file.absolutePath
    }

    fun getAudioFiles(): List<String> {
        val dir = File(UPLOAD_DIR)
        return dir.listFiles()?.map { it.name } ?: emptyList()
    }
}
