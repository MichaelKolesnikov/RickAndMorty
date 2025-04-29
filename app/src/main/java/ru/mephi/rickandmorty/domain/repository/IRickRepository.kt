package ru.mephi.rickandmorty.domain.repository

import ru.mephi.rickandmorty.domain.entity.CharacterEntity

interface IRickRepository {
    suspend fun getAllCharacters(forceRefresh: Boolean = false): List<CharacterEntity>
}