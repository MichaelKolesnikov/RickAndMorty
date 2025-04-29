package ru.mephi.rickandmorty.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mephi.rickandmorty.data.model.CharacterModel
import ru.mephi.rickandmorty.data.service.CharacterDAO

@Database(
    entities = [CharacterModel::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun characterDAO(): CharacterDAO
}