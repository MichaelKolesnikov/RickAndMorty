package ru.mephi.rickandmorty.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val created: String,
    val episode: List<String>,
    val location: CharacterLocationDTO,
    val origin: CharacterOriginDTO,
    val type: String,
    val url: String
)