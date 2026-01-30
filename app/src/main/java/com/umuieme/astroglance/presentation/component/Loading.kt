package com.umuieme.astroglance.presentation.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Loading(modifier: Modifier){
    CircularProgressIndicator(
        modifier = modifier
    )
}

@Preview
@Composable
fun LoadingPreview(){
    Loading(modifier = Modifier)
}