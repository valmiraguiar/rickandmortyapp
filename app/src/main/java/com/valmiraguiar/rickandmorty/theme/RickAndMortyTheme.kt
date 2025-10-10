package com.valmiraguiar.rickandmorty.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val lightColorScheme = AppColorScheme(
    background = White,
    onBackground = Black100,
    primary = Blue100,
    onPrimary = White100,
    secondary = Blue300,
    onSecondary = White100,
    tertiary = Blue200,
    onTertiary = White100
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme: AppColorScheme = lightColorScheme

    CompositionLocalProvider(
        LocalAppColorScheme provides colorScheme,
        LocalAppTypography provides typography,
        LocalAppShape provides shape,
        LocalAppSize provides size,
        content = content
    )
}

object RickAndMortyTheme {
    val colorScheme: AppColorScheme
        @Composable get() = LocalAppColorScheme.current

    val typography: AppTypography
        @Composable get() = LocalAppTypography.current

    val shape: AppShape
        @Composable get() = LocalAppShape.current

    val size: AppSize
        @Composable get() = LocalAppSize.current
}