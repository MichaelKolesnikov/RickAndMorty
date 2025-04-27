package ru.mephi.rickandmorty.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocationDTO,
    val name: String,
    val origin: CharacterOriginDTO,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)