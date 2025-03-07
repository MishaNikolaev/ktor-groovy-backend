package com.nmichail.services

import com.nmichail.models.Song
import com.nmichail.repositories.SongRepository
import com.nmichail.utils.FileUtils
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MusicService : KoinComponent {
    private val songRepository: SongRepository by inject()

    fun getAllSongs(): List<Song> = songRepository.getAllSongs()

    fun getSongById(id: String): Song? = songRepository.getSongById(id)

    fun addSong(song: Song): String = songRepository.addSong(song)
}