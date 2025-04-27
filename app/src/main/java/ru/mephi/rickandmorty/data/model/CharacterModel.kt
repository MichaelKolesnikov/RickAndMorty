package ru.mephi.rickandmorty.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Character")
class CharacterModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val age: Int,
    val image: String,
    val status: String,
) {
}