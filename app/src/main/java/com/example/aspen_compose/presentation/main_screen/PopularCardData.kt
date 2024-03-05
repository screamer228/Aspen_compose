package com.example.aspen_compose.presentation.main_screen

import androidx.annotation.DrawableRes

data class PopularCardData(
    @DrawableRes val imageId: Int,
    val label: String,
    val rating: String
)
