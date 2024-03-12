package com.example.aspen_compose.data

import com.example.aspen_compose.R
import com.example.aspen_compose.presentation.detail_screen.uistate.DetailUiState
import com.example.aspen_compose.presentation.model.PopularCardData
import com.example.aspen_compose.presentation.model.RecommendedCardData
import com.example.aspen_compose.presentation.main_screen.uistate.MainUiState

object DataMock {

    fun getData(): MainUiState {
        return (
                MainUiState(
                    mutableListOf(
                        PopularCardData(
                            R.drawable.img_alley_palace,
                            "Alley Palace",
                            "4.1",
                            true
                        ),
                        PopularCardData(
                            R.drawable.img_coeurdes_alpes,
                            "Coeurdes Alpes",
                            "4.5",
                            false
                        )
                    ),
                    mutableListOf(
                        RecommendedCardData(
                            R.drawable.img_explore_aspen,
                            "Explore Aspen",
                            "4N/5D"
                        ),
                        RecommendedCardData(
                            R.drawable.img_luxurious_aspen,
                            "Luxurious Aspen",
                            "2N/3D"
                        )
                    )
                )
                )
    }

    fun getDataByIndex(index: Int): DetailUiState {
        val data = getData()

        return DetailUiState(
            data.popularCardData[index]
        )
    }
}