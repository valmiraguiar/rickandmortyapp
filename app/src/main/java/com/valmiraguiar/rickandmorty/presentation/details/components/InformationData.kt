package com.valmiraguiar.rickandmorty.presentation.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.valmiraguiar.rickandmorty.theme.Dimensions
import com.valmiraguiar.rickandmorty.theme.Gray100
import com.valmiraguiar.rickandmorty.theme.RickAndMortyTheme

private const val MAX_LINES = 1

@Composable
fun InformationData(
    modifier: Modifier = Modifier,
    label: String,
    value: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimensions.SpacingXNano)
    ) {
        Text(
            text = label,
            style = RickAndMortyTheme.typography.labelSmall,
            color = Gray100,
            maxLines = MAX_LINES
        )

        Text(
            text = value,
            style = RickAndMortyTheme.typography.body,
            color = Gray100,
            maxLines = MAX_LINES
        )
    }
}