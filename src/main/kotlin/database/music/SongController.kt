package com.nmichail.database.music

import com.nmichail.models.Song
import com.nmichail.services.MusicService
import org.koin.java.KoinJavaComponent.inject


class SongController {

    private val musicService: MusicService by inject()

    fun getAllSongs(): List<Song> = musicService.getAllSongs()

    fun getSongById(id: String): Song? = musicService.getSongById(id)

    fun addSong(song: Song): String = musicService.addSong(song)
}