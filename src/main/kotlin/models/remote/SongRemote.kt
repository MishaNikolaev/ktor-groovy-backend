package com.nmichail.models.remote

import com.nmichail.models.Song
import com.sun.source.doctree.AuthorTree
import kotlinx.serialization.Serializable

@Serializable
data class SongRemote(
    val id: Int,
    val title: String,
    val author: String,
    val duration: Int,
    val audio: String
)
