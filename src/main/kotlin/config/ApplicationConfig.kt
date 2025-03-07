package com.nmichail.config



import com.nmichail.database.music.Musics
import com.nmichail.database.users.Users
import com.nmichail.repositories.SongRepository
import com.nmichail.repositories.UserRepository
import com.nmichail.services.MusicService
import com.nmichail.services.UserService
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    single { SongRepository() }
    single { UserRepository() }

    single { MusicService(get()) }
    single { UserService(get()) }

    single { Musics }
    single { Users }
}