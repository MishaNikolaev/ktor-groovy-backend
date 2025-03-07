package com.nmichail.services

import com.nmichail.models.Song
import com.nmichail.utils.FileUtils
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MusicService : KoinComponent {
    fun getAllTracks(): List<String> {
        return FileUtils.getAudioFiles()
    }
}