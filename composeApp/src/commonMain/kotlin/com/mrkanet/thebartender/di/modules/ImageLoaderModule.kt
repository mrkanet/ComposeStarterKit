package com.mrkanet.thebartender.di.modules

import androidx.compose.runtime.Composable
import coil3.ImageLoader

object ImageLoaderModule {
    @Composable
    fun provideImageLoader(): ImageLoader {
        return rememberImageLoader()
    }

    fun createImageLoader(): ImageLoader {
        return createPlatformImageLoader()
    }
}

@Composable
expect fun rememberImageLoader(): ImageLoader
expect fun createPlatformImageLoader(): ImageLoader