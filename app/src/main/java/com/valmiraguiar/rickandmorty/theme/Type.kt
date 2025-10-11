package com.valmiraguiar.rickandmorty.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = AppTypography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    titleNormal = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    ),
    body = TextStyle(
        fontSize = 12.sp,
        color = Gray100
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