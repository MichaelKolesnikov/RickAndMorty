package ru.mephi.rickandmorty

import android.app.Application
import ru.mephi.rickandmorty.common.di.viewModelModule
import ru.mephi.rickandmorty.common.di.appModule
import ru.mephi.rickandmorty.common.di.databaseModule
import ru.mephi.rickandmorty.common.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CharacterApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CharacterApplication)
            modules(listOf(viewModelModule, databaseModule, repositoryModule, appModule))
        }
    }
}