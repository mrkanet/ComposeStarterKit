package com.mrkanet.thebartender.di.modules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@Composable
fun ImageLoaderProvider(
    content: @Composable () -> Unit
) {
// In Coil 3, no need for LocalImageLoader - just call content directly
    content()
}

@Composable
fun NetworkImage(
    url: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    placeholderPainter: Painter? = null,
    errorPainter: Painter? = null
) {
    val imageLoader = ImageLoaderModule.provideImageLoader()
    AsyncImage(
        model = url,
        imageLoader = imageLoader,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
        placeholder = placeholderPainter,
        error = errorPainter
    )
}

@Composable
fun NetworkImageWithLoading(
    url: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    showLoadingIndicator: Boolean = true
) {
    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }
    val imageLoader = ImageLoaderModule.provideImageLoader()

    Box(modifier = modifier) {
        AsyncImage(
            model = url,
            imageLoader = imageLoader,
            contentDescription = contentDescription,
            contentScale = contentScale,
            onSuccess = {
                isLoading = false
                hasError = false
            },
            onError = {
                isLoading = false
                hasError = true
            },
            modifier = Modifier.fillMaxSize()
        )

        if (isLoading && showLoadingIndicator) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (hasError) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Failed to load image",
                    color = androidx.compose.material.MaterialTheme.colors.error
                )
            }
        }
    }
}

@Composable
fun DrinkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    showLoading: Boolean = true
) {
    if (showLoading) {
        NetworkImageWithLoading(
            url = imageUrl,
            contentDescription = "Drink image",
            modifier = modifier,
            contentScale = contentScale
        )
    } else {
        NetworkImage(
            url = imageUrl,
            contentDescription = "Drink image",
            modifier = modifier,
            contentScale = contentScale
        )
    }
}