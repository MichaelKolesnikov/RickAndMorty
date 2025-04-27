package ru.mephi.rickandmorty.data.service

import androidx.room.Dao
import androidx.room.Query
import ru.mephi.rickandmorty.data.model.CharacterModel

@Dao
interface CharacterDAO {
    @Query("SELECT * FROM Character")
    suspend fun getAllCharacters(): List<CharacterModel>

    @Query("SELECT * FROM Character WHERE id = :id")
    suspend fun getCharacterById(id: String): CharacterModel
}