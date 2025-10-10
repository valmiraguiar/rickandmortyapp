package com.valmiraguiar.rickandmorty.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = AppTypography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp
    ),
    titleNormal = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    ),
    body = TextStyle(
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 44.sp
    ),
    labelNormal = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)