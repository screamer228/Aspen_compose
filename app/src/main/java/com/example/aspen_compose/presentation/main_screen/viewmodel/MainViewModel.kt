package com.example.aspen_compose.presentation.main_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aspen_compose.data.DataMock.getData
import com.example.aspen_compose.presentation.main_screen.uistate.MainUiState

class MainViewModel : ViewModel() {

    private val _uiState: MutableLiveData<MainUiState> = MutableLiveData()
    val uiState: LiveData<MainUiState> = _uiState

    fun getStateData() {
        _uiState.postValue(getData())
    }

    fun getInitialState(): MainUiState {
        getStateData()
        return getData()
    }
}