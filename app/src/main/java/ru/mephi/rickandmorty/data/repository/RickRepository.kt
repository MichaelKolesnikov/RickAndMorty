package ru.mephi.rickandmorty.data.repository

import ru.mephi.rickandmorty.data.mapper.CharacterMapper
import ru.mephi.rickandmorty.data.service.CharacterDAO
import ru.mephi.rickandmorty.data.service.RickApiService
import ru.mephi.rickandmorty.domain.entity.CharacterEntity
import ru.mephi.rickandmorty.domain.repository.IRickRepository

class RickRepository(
    private val apiService: RickApiService,
    private val dao: CharacterDAO,
): IRickRepository {
    override suspend fun getAllCharacters(forceRefresh: Boolean): List<CharacterEntity> {
        try {
            val localData = dao.getAllCharacters()
            if (localData.isEmpty() || forceRefresh){
                val remoteData = apiService.getAllCharacters()
                // TODO: save remote data to local database
                dao.insertAll(remoteData.results.map { CharacterMapper.mapDTOToModel(it) })
                return remoteData.results.map { CharacterMapper.mapDTOEntity(it) }
            }
            return localData.map { CharacterMapper.mapModelToEntity(it)}
        } catch (e: Exception) {
            throw Exception(e.message + "|" + e.localizedMessage, e)
        }
    }
}