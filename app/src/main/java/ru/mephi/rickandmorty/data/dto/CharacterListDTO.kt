package ru.mephi.rickandmorty.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListDTO(
    val info: CharacterInfoDTO,
    val results: List<CharacterDTO>,
)
