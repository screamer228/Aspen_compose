package com.example.aspen_compose.presentation.model

import androidx.annotation.DrawableRes

data class RecommendedCardData(
    @DrawableRes val imageId: Int,
    val label: String,
    val duration: String
)
