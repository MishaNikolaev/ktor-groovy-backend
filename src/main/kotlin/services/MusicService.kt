package com.nmichail.services

import com.nmichail.models.Song
import com.nmichail.repositories.SongRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MusicService : KoinComponent {
    private val songRepository by inject<SongRepository>()

    suspend fun getAllSongs(): List<Song> {
        return songRepository.findAll()
    }

    suspend fun getSongById(id: String): Song? {
        return songRepository.findById(id)
    }
}