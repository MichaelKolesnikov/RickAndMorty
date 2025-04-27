package ru.mephi.rickandmorty.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mephi.rickandmorty.data.model.CharacterModel
import ru.mephi.rickandmorty.data.service.CharacterDAO

@Database(
    entities = [CharacterModel::class],
    version = 1,
    exportSchema = false,
)
abstract class Database: RoomDatabase() {
    abstract fun characterDAO(): CharacterDAO

    companion object {
        const val DATABASE_NAME = "RickAndMortyDatabase.db"
    }
}