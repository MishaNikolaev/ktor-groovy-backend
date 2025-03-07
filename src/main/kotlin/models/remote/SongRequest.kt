package com.nmichail.models.remote

import kotlinx.serialization.Serializable

@Serializable
data class SongRequest(
    val id: Int,
    val title: String,
    val author: String,
    val duration: Int,
    val audio: String
)