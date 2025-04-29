package ru.mephi.rickandmorty.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterOriginDTO(
    val name: String,
    val url: String
)