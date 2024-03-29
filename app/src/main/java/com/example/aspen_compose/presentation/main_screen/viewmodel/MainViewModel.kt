package com.example.aspen_compose.presentation.main_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aspen_compose.data.DataMock.getData
import com.example.aspen_compose.presentation.main_screen.uistate.MainUiState

class MainViewModel : ViewModel() {

    private val _uiState: MutableLiveData<MainUiState> = MutableLiveData(getData())
    val uiState: LiveData<MainUiState> = _uiState

    init {
        getStateData()
    }

    private fun getStateData() {
        _uiState.postValue(getData())
    }
}