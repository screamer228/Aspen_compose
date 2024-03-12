package com.example.aspen_compose.presentation.model

import androidx.annotation.DrawableRes

data class PopularCardData(
    @DrawableRes val imageId: Int,
    val label: String,
    val rating: String,
    val isFavorite: Boolean
)
