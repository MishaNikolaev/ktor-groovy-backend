package com.nmichail.database

import com.nmichail.models.Song
import com.nmichail.repositories.SongRepository
import java.util.concurrent.atomic.AtomicInteger

class InMemorySongRepository : SongRepository {
    private val songs = mutableListOf<Song>()
    private val idCounter = AtomicInteger(1)

    override fun getAllSongs(): List<Song> = songs

    override fun getSongById(id: String): Song? = songs.find { it.id == id }

    override fun addSong(song: Song): String {
        val newSong = song.copy(id = idCounter.getAndIncrement().toString())
        songs.add(newSong)
        return newSong.id
    }
}