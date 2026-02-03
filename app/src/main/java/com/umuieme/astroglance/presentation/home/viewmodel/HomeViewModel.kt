package com.umuieme.astroglance.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umuieme.astroglance.domain.model.ApodModel
import com.umuieme.astroglance.domain.repository.ApodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ApodRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeState>(HomeState.Loading)
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    private var lastEndDate: LocalDate = LocalDate.now()
    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE
    private val PAGE_SIZE = 20
    private var isFetching = false

    init {
        fetchApodList()
    }

    fun fetchApodList() {
        if (isFetching) return
        isFetching = true

        viewModelScope.launch {
            val currentState = _uiState.value
            if (currentState is HomeState.Success) {
                _uiState.value = currentState.copy(isLoadingMore = true)
            } else {
                _uiState.value = HomeState.Loading
            }

            try {
                val endDate = lastEndDate
                val startDate = endDate.minusDays(PAGE_SIZE.toLong() - 1)

                val data = repository.getApod(
                    startDate = startDate.format(dateFormatter),
                    endDate = endDate.format(dateFormatter)
                )

                val sortedData = data.sortedByDescending { it.date }

                if (currentState is HomeState.Success) {
                    _uiState.value = HomeState.Success(
                        items = currentState.items + sortedData,
                        isLoadingMore = false
                    )
                } else {
                    _uiState.value = HomeState.Success(sortedData)
                }

                lastEndDate = startDate.minusDays(1)
            } catch (e: Exception) {
                e.printStackTrace()
                if (_uiState.value !is HomeState.Success) {
                    _uiState.value = HomeState.Error(e.message ?: "Unknown error")
                }
            } finally {
                isFetching = false
            }
        }
    }

    fun onListScroll(lastVisibleItemIndex: Int, totalItemsCount: Int) {
        if (totalItemsCount > 0 && lastVisibleItemIndex >= totalItemsCount - 3) {
            fetchApodList()
        }
    }
}