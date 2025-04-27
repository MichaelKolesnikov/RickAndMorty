package ru.mephi.rickandmorty.data.service

import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.mephi.rickandmorty.common.api.NetworkModule
import ru.mephi.rickandmorty.data.dto.CharacterDTO
import ru.mephi.rickandmorty.data.dto.CharacterListDTO

object RickApiService {
    private const val BASE_URL = "https://rickandmortyapi.com/api"

    suspend fun getAllCharacters(): CharacterListDTO {
        val response = NetworkModule.publicClient.get("$BASE_URL/character").body<CharacterListDTO>()
        return response
    }

    suspend fun getCharacterById(id: Int): CharacterDTO {
        val response = NetworkModule.publicClient.get("$BASE_URL/character/$id").body<CharacterDTO>()
        return response
    }
}