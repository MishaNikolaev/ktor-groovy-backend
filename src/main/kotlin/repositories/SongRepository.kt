package com.nmichail.repositories


import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import com.nmichail.models.Song
import org.bson.Document
import org.bson.types.ObjectId

class SongRepository(private val collection: MongoCollection<Document>) {

    suspend fun create(song: Song): String {
        val doc = Document()
            .append("title", song.title)
            .append("artist", song.artist)
            .append("album", song.album)
            .append("duration", song.duration)
            .append("filePath", song.filePath)
            .append("coverPath", song.coverPath)

        collection.insertOne(doc)
        return doc["_id"].toString()
    }

    suspend fun findById(id: String): Song? {
        val doc = collection.find(Filters.eq("_id", ObjectId(id))).first()
        return doc?.let {
            Song(
                id = it["_id"].toString(),
                title = it.getString("title"),
                artist = it.getString("artist"),
                album = it.getString("album"),
                duration = it.getInteger("duration"),
                filePath = it.getString("filePath"),
                coverPath = it.getString("coverPath")
            )
        }
    }

    suspend fun findAll(): List<Song> {
        return collection.find().map {
            Song(
                id = it["_id"].toString(),
                title = it.getString("title"),
                artist = it.getString("artist"),
                album = it.getString("album"),
                duration = it.getInteger("duration"),
                filePath = it.getString("filePath"),
                coverPath = it.getString("coverPath")
            )
        }.toList()
    }
}