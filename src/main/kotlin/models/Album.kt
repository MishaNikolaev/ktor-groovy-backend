package com.nmichail.models

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: String,
    val title: String,
    val artist: String,
    val coverPath: String,
    val songs: List<Song>
)