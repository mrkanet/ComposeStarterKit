package com.mrkanet.thebartender.di.modules

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil3.ImageLoader
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.PlatformContext
@Composable
actual fun rememberImageLoader(): ImageLoader {
    return remember {
        createPlatformImageLoader()
    }
}
actual fun createPlatformImageLoader(): ImageLoader {
    return ImageLoader.Builder(PlatformContext.INSTANCE)
        .components {
            add(KtorNetworkFetcherFactory())
        }
        .build()
}