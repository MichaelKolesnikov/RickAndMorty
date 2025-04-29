package ru.mephi.rickandmorty.data.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.mephi.rickandmorty.data.database.LocalDatabase
import ru.mephi.rickandmorty.data.repository.RickRepository
import ru.mephi.rickandmorty.data.service.RickApiService
import ru.mephi.rickandmorty.domain.repository.IRickRepository

val dataModule = module {
    single<IRickRepository> {
        RickRepository(
            apiService = get(),
            dao = get()
        )
    }

    single { RickApiService }
    single { get<LocalDatabase>().characterDAO() }

    single {
        Room.databaseBuilder(
            androidContext(),
            LocalDatabase::class.java,
            "app_database"
        ).build()
    }
}