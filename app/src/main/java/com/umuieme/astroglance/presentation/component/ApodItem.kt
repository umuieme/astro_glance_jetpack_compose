package com.umuieme.astroglance.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.umuieme.astroglance.R
import com.umuieme.astroglance.domain.model.ApodModel

@Composable
fun ApodItem(apodModel: ApodModel, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().background(Color.Black)) {
        AsyncImage(
            model = apodModel.hdUrl,
            contentDescription = apodModel.explanation,
            placeholder = painterResource(R.drawable.ic_loading),
            error = painterResource(R.drawable.invalid_image),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )



        // 3. Info Content

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .background(
                    brush = Brush.verticalGradient(
                        colors =  listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.5f),
                        )
                    )
                )

                .padding(horizontal = 20.dp, vertical = 40.dp)
            .padding(end = 48.dp)

            ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart),
                verticalArrangement = Arrangement.spacedBy(8.dp)


            ) {
                Text(
                    text = apodModel.title,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        shadow = Shadow(offset = Offset(2f, 2f), blurRadius = 4f)
                    )
                )

                // Date Chip
                Surface(
                    color = Color.White.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = apodModel.date,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Text(
                    text = apodModel.explanation,
                    color = Color.White.copy(alpha = 0.9f),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // 4. Action Sidebar (Tiktok Style)
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 12.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ActionButton(icon = Icons.Default.Favorite, label = "Like")
            ActionButton(icon = Icons.AutoMirrored.Filled.Send, label = "Share")
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(Color.White.copy(alpha = 0.15f), CircleShape)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = label, tint = Color.White)
        }
        Text(text = label, color = Color.White, fontSize = 10.sp, modifier = Modifier.padding(top = 4.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun ApodItemPreview() {
    ApodItem(
        apodModel = ApodModel(
            copyright = "Umesh Basnet",
            date = "2026-01-02",
            explanation = "In 2011, on January 20, NASA's NanoSail-D2 unfurled a very thin and very reflective 10 square meter sail becoming the first solar sail spacecraft in low Earth orbit. Often considered the stuff of science fiction, sailing through space was suggested 400 years ago by astronomer Johannes Kepler, who had observed comet tails blown by the solar wind. But modern solar sail spacecraft designs, like NanoSail-D2, Japan's interplanetary spacecraft IKAROS, or the Planetary Society's Lightsail A, rely on the small but continuous pressure from sunlight itself for thrust. Glinting in the sunlight as it circled planet Earth, NanoSail-D2's solar sail was periodically bright and visible to the eye. These remarkably detailed images were captured by manually tracking the orbiting solar sail spacecraft with a small telescope.",
            hdUrl = "https://apod.nasa.gov/apod/image/2601/NanosailD2_reprocessed1a.png",
            mediaType = "image",
            title = "NanoSail-D2",
            url = "https://apod.nasa.gov/apod/image/2601/NanosailD2_reprocessed1a1024.png",
        )
    )
}