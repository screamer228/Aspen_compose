package com.example.aspen_compose.presentation.main_screen.uistate

import com.example.aspen_compose.presentation.model.PopularCardData
import com.example.aspen_compose.presentation.model.RecommendedCardData

data class MainUiState(
    val popularCardData: List<PopularCardData> = listOf(),
    val recommendedCardData: List<RecommendedCardData> = listOf()
)
