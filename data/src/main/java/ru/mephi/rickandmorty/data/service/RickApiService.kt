package ru.mephi.rickandmorty.data.service

import android.util.Log
import ru.mephi.rickandmorty.common.api.NetworkModule
import ru.mephi.rickandmorty.data.dto.CharacterDTO
import ru.mephi.rickandmorty.data.dto.CharacterListDTO
import io.ktor.client.call.body
import io.ktor.client.request.get

object RickApiService {
    private const val BASE_URL = "https://rickandmortyapi.com/api"

    suspend fun getAllCharacters(): CharacterListDTO {
        try {
            return NetworkModule.publicClient.get("$BASE_URL/character").body()
        } catch (e: Exception) {
            Log.d("net222", "loadCharacters: ${e.message}")
            throw Exception(e)
        }
    }

    suspend fun getCharacterById(id: Int): CharacterDTO {
        return NetworkModule.publicClient.get("$BASE_URL/character/$id").body()
    }
}