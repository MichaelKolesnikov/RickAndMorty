package ru.mephi.rickandmorty.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.mephi.rickandmorty.presentation.viewmodel.CharacterViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterScreen(
    viewModel: CharacterViewModel = koinViewModel()
) {
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isError by viewModel.isError.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.loadCharacters()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Персонажи") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                coroutineScope.launch(Dispatchers.IO) {
                    viewModel.loadCharacters(true)
                }
            }) {
                Icon(Icons.Default.Refresh, contentDescription = "Обновить")
            }
        }
    ) {
            padding ->
        Box(modifier = Modifier.padding(padding)) {
            when {
                isLoading -> {
                    Text(
                        text = "Загрузка данных. Подождите...",
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                }

                isError -> {
                    Text(
                        text = "Ошибка загрузки данных.",
                        color = Color.Red,
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                }

                else -> {
                    LazyColumn {
                        items(characters) { character ->
                            CharacterView(character)
                        }
                    }
                }
            }
        }
    }
}
