package com.umuieme.astroglance.presentation.home.viewmodel

import com.umuieme.astroglance.domain.model.ApodModel

sealed interface HomeState {

    data object Loading : HomeState
    data class Success(
        val items: List<ApodModel>
    ) : HomeState

    data class Error(val message: String) : HomeState
}