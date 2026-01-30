package com.umuieme.astroglance.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umuieme.astroglance.domain.repository.ApodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ApodRepository
) : ViewModel() {

    private  val _uiState = MutableStateFlow<HomeState>(HomeState.Loading)
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    init {
        fetchApodList()
    }

    fun fetchApodList() {
        viewModelScope.launch {
            _uiState.value = HomeState.Loading
            try {
                val data = repository.getApod()
                _uiState.value = HomeState.Success(data.reversed())
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.value = HomeState.Error(e.message ?: "Unknown error")
            }
        }
    }

}