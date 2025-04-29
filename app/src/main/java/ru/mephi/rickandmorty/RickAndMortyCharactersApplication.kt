package ru.mephi.rickandmorty

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import ru.mephi.rickandmorty.data.di.dataModule
import ru.mephi.rickandmorty.presentation.di.viewModelModule

class RickAndMortyCharactersApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RickAndMortyCharactersApplication)
            modules(listOf(viewModelModule, dataModule))
        }
    }
}