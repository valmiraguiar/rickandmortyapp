package com.valmiraguiar.rickandmorty.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@Composable
fun DetailsScreen(
    characterId: Int
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}