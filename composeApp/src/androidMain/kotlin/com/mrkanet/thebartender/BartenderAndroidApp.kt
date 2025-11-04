package com.mrkanet.thebartender

import android.app.Application
import android.content.Context
import coil3.ImageLoader
import com.mrkanet.thebartender.di.initKoin
import com.mrkanet.thebartender.di.modules.createImageLoaderForContext
import org.koin.android.ext.koin.androidContext

class BartenderAndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BartenderAndroidApp)
        }
    }
}