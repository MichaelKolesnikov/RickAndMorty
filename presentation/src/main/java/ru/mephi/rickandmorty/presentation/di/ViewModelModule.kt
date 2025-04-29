package ru.mephi.rickandmorty.presentation.di

import org.koin.dsl.module
import ru.mephi.rickandmorty.presentation.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
}