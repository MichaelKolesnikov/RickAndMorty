package ru.mephi.rickandmorty.data.repository

import ru.mephi.rickandmorty.data.mapper.CharacterMapper
import ru.mephi.rickandmorty.data.service.CharacterDAO
import ru.mephi.rickandmorty.data.service.RickApiService
import ru.mephi.rickandmorty.domain.entity.CharacterEntity
import ru.mephi.rickandmorty.domain.repository.IRichRepository
import javax.sql.DataSource

class RickRepository(
    private val rickApiService: RickApiService,
    private val dao: CharacterDAO,
): IRichRepository {
    override suspend fun getAllCharacters(forceRefresh: Boolean): List<CharacterEntity> {
        val localData = dao.getAllCharacters()
        if (localData.isEmpty() || forceRefresh) {
            val remoteData = rickApiService.getAllCharacters()
            return remoteData.results.map { CharacterMapper.mapDTOtoEntity(it) }
        }
        return localData.map { CharacterMapper.mapModelToEntity(it) }
    }
}