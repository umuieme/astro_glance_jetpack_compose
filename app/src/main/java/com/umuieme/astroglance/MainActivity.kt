package com.umuieme.astroglance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.umuieme.astroglance.ui.theme.ApodItem
import com.umuieme.astroglance.ui.theme.AstroGlanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AstroGlanceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val images = listOf(
                        "https://apod.nasa.gov/apod/image/2510/WitchBroom_Meyers_1080.jpg",
                        "https://apod.nasa.gov/apod/image/2510/WitchBroom_Meyers_1080.jpg",
                        "https://apod.nasa.gov/apod/image/2510/WitchBroom_Meyers_1080.jpg",
                        "https://apod.nasa.gov/apod/image/2510/WitchBroom_Meyers_1080.jpg"
                    )
                    VerticalSwipeFeed(
                        images = images,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun VerticalSwipeFeed(images: List<String>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(pageCount = { images.size })
    
    VerticalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize(),
        key = { it }
    ) { page ->
        ApodItem(imageUrl = images[page])
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AstroGlanceTheme {
        VerticalSwipeFeed(
            images = listOf("https://apod.nasa.gov/apod/image/2510/WitchBroom_Meyers_1080.jpg")
        )
    }
}
