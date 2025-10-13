package com.valmiraguiar.rickandmorty.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme

@Composable
fun Loading(isVisible: Boolean = false) {
    if(isVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = RickAndMortyTheme.colorScheme.onBackground
            )
        }
    }
}