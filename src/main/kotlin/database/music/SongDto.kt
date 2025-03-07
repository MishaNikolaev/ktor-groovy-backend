package com.nmichail.database.music

data class SongDto(
    val id: Int,
    val title: String,
    val artist: String,
    val audio: String,
    val album: String,
    val duration: Long,
    val smallCover: String?
)
