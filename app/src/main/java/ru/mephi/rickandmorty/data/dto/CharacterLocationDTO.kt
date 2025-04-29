package ru.mephi.rickandmorty.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterLocationDTO(
    val name: String,
    val url: String
)