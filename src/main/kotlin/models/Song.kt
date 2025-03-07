package com.nmichail.models

import kotlinx.serialization.Serializable


@Serializable
data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val duration: Int,
    val smallCover: String?,
    val largeCover: String?
)
