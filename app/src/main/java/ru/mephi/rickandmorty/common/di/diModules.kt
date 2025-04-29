package ru.mephi.rickandmorty.common.di

import androidx.room.Room
import ru.mephi.rickandmorty.common.database.AppDatabase
import ru.mephi.rickandmorty.domain.repository.IRickRepository
import ru.mephi.rickandmorty.data.repository.RickRepository
import ru.mephi.rickandmorty.data.service.RickApiService
import ru.mephi.rickandmorty.presentation.viewmodel.CharacterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}

val repositoryModule = module {
    single<IRickRepository> { RickRepository(RickApiService, get()) }
}

val appModule = module {
    single { get<AppDatabase>().characterDAO() }
}