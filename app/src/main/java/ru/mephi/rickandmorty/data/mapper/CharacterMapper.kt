package ru.mephi.rickandmorty.data.mapper

import androidx.core.net.toUri
import ru.mephi.rickandmorty.data.dto.CharacterDTO
import ru.mephi.rickandmorty.data.model.CharacterModel
import ru.mephi.rickandmorty.domain.entity.CharacterEntity

abstract class CharacterMapper {
    companion object{
        fun mapDTOEntity(dto: CharacterDTO): CharacterEntity {
            return CharacterEntity(
                name = dto.name,
                image = dto.image.toUri(),
                status = dto.status,
                species = dto.species
            )
        }
        fun mapModelToEntity(model: CharacterModel): CharacterEntity {
            return CharacterEntity(
                name = model.name,
                image = model.image.toUri(),
                status = model.status,
                species = model.species
            )
        }
        fun mapDTOToModel(dto: CharacterDTO): CharacterModel {
            return CharacterModel(
                name = dto.name,
                image = dto.image,
                status = dto.status,
                species = dto.species
            )
        }
    }
}