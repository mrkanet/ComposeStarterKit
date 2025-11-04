package com.mrkanet.thebartender.di.modules

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import coil3.ImageLoader
import coil3.network.ktor3.KtorNetworkFetcherFactory

@Composable
actual fun rememberImageLoader(): ImageLoader {
    val context = LocalContext.current
    return remember(context) {
        createImageLoaderForContext(context)
    }
}

actual fun createPlatformImageLoader(): ImageLoader {
    throw IllegalStateException("Use rememberImageLoader() in Compose or inject Context")
}

fun createImageLoaderForContext(context: Context): ImageLoader {
    return ImageLoader.Builder(context)
        .components {
            add(KtorNetworkFetcherFactory())
        }
        .build()
}