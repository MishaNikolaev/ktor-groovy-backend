package com.nmichail.database.music

import org.jetbrains.exposed.sql.Table

object Musics : Table("musics") {
    val id = integer("music_id").autoIncrement()
    val title = varchar("title", 64)
    val artist = varchar("artist", 64)
    val audio = varchar("audio", 256)
    val duration = long("duration")
    val smallCover = varchar("small_cover", 256).nullable()
    val largeCover = varchar("large_cover", 256).nullable()

    override val primaryKey = PrimaryKey(id)
}