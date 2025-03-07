package com.nmichail.repositories

import com.nmichail.database.music.Musics
import com.nmichail.models.Song
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class SongRepository {

    fun getAllSongs(): List<Song> = transaction {
        Musics.selectAll().map {
            Song(
                id = it[Musics.id].toString(),
                title = it[Musics.title],
                artist = it[Musics.artist],
                album = "",
                duration = it[Musics.duration].toInt(),
                smallCover = it[Musics.smallCover],
                largeCover = it[Musics.largeCover]
            )
        }
    }

    fun getSongById(id: String): Song? = transaction {
        Musics.select { Musics.id eq id.toInt() }.singleOrNull()?.let {
            Song(
                id = it[Musics.id].toString(),
                title = it[Musics.title],
                artist = it[Musics.artist],
                album = "",
                duration = it[Musics.duration].toInt(),
                smallCover = it[Musics.smallCover],
                largeCover = it[Musics.largeCover]
            )
        }
    }

    fun addSong(song: Song): String = transaction {
        Musics.insert {
            it[Musics.title] = song.title
            it[Musics.artist] = song.artist
            it[Musics.duration] = song.duration.toLong()
            it[Musics.smallCover] = song.smallCover
            it[Musics.largeCover] = song.largeCover
        }[Musics.id].toString()
    }
}