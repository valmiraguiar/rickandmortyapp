package com.valmiraguiar.rickandmorty.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.valmiraguiar.rickandmorty.R
import com.valmiraguiar.rickandmorty.theme.Dimensions
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.TopBarHeight)
            .padding(Dimensions.SpacingXSNano)
            .background(RickAndMortyTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.rickandmorty_logo),
            contentDescription = "Rick and Morty Logo",
        )
    }
}