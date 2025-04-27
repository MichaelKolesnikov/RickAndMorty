package ru.mephi.rickandmorty.domain.repository

import ru.mephi.rickandmorty.domain.entity.CharacterEntity

interface IRichRepository {
    suspend fun getAllCharacters(forceRefresh: Boolean = false): List<CharacterEntity>
}