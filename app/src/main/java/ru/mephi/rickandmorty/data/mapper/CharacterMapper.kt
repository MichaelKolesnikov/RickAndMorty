package ru.mephi.rickandmorty.data.mapper

import ru.mephi.rickandmorty.data.dto.CharacterDTO
import ru.mephi.rickandmorty.domain.entity.CharacterEntity
import androidx.core.net.toUri
import ru.mephi.rickandmorty.data.model.CharacterModel

abstract class CharacterMapper {
    companion object {
        fun mapDTOtoEntity(dto: CharacterDTO): CharacterEntity {
            return CharacterEntity(
                name = dto.name,
                image = dto.image.toUri(),
                status = dto.status
            )
        }

        fun mapModelToEntity(model: CharacterModel): CharacterEntity {
            return CharacterEntity(
                name = model.name,
                image = model.image.toUri(),
                status = model.status
            )
        }
    }
}