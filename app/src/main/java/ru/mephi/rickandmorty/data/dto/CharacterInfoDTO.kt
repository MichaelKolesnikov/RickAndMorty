package ru.mephi.rickandmorty.data.dto

data class CharacterInfoDTO(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)