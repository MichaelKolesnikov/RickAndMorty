package ru.mephi.rickandmorty.presentation.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.mephi.rickandmorty.domain.entity.CharacterEntity
import ru.mephi.rickandmorty.domain.repository.IRichRepository

class CharacterViewModel(
    private val repository: IRichRepository,
) {
    private val _characters = MutableStateFlow(emptyList<CharacterEntity>())
    val characters: StateFlow<List<CharacterEntity>> = _characters.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError.asStateFlow()

    suspend fun loadCharacters(forceRefresh: Boolean = false) {
        _isLoading.value = true
        _isError.value = false
        try {
            val charactersList = repository.getAllCharacters(forceRefresh)
            _characters.value = charactersList
        } catch (e: Exception) {
            _isError.value = true
        } finally {
            _isLoading.value = false
        }
    }
}