package com.nmichail.models

import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
    val id: String,
    val title: String,
    val songs: List<Song>
)