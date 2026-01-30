package com.umuieme.astroglance.presentation.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.umuieme.astroglance.presentation.component.ErrorView
import com.umuieme.astroglance.presentation.component.Loading
import com.umuieme.astroglance.presentation.home.viewmodel.HomeState
import com.umuieme.astroglance.presentation.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), modifier: Modifier){
    val state by viewModel.uiState.collectAsState()
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        when (val s = state) {
            is HomeState.Loading -> Loading(modifier = Modifier.align(Alignment.Center))
            is HomeState.Error -> ErrorView(message = s.message, modifier = Modifier.align(Alignment.Center))
            is HomeState.Success -> ApodHomeListView(apodList = s.items)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)
}