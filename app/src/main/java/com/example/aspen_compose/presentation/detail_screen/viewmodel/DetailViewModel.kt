package com.example.aspen_compose.presentation.detail_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aspen_compose.data.DataMock.getDataByIndex
import com.example.aspen_compose.presentation.detail_screen.uistate.DetailUiState

class DetailViewModel : ViewModel() {

    private val _uiState: MutableLiveData<DetailUiState> = MutableLiveData()
    val uiState: LiveData<DetailUiState> = _uiState

    fun getStateByIndex(index: Int) {
        val stateResult = getDataByIndex(index)
        _uiState.postValue(stateResult)
    }

}