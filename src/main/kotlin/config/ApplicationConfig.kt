package com.nmichail.config

import org.koin.dsl.module
/*
val appModule = module {
    single { SongRepository() }
    single { UserRepository() }

    single { MusicService(get()) }
    single { UserService(get()) }

    single { Musics }
    single { Users }
}
*/

import com.nmichail.database.InMemorySongRepository
import com.nmichail.database.InMemoryUserRepository
import com.nmichail.repositories.SongRepository
import com.nmichail.repositories.UserRepository
import com.nmichail.services.MusicService
import com.nmichail.services.UserService
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    single<SongRepository> { InMemorySongRepository() }
    single<UserRepository> { InMemoryUserRepository() }

    single { MusicService(get<SongRepository>()) }
    single { UserService(get<UserRepository>()) }
}