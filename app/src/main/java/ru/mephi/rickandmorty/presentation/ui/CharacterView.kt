package ru.mephi.rickandmorty.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import ru.mephi.rickandmorty.domain.entity.CharacterEntity


@Composable
fun CharacterView(character: CharacterEntity) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            AsyncImage(
                model = character.image.toUri(),
                contentDescription = "Картинка ${character.name}",
                modifier = Modifier
                    .size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Name: ${character.name}",
                    fontSize = 20.sp,
                    modifier = Modifier
                )
                Text(
                    text = "Status: ${character.status}",
                    fontSize = 20.sp,
                    modifier = Modifier
                )
                Text(
                    text = "Species: ${character.species}",
                    fontSize = 20.sp,
                    modifier = Modifier
                )
            }
        }
    }
}