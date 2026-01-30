package com.umuieme.astroglance.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorView(message: String, modifier: Modifier) {
    Text(
        text = message,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ErrorViewPreview() {
    ErrorView(message = "This is an error message", modifier = Modifier)
}