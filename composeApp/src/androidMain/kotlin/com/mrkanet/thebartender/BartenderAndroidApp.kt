package com.mrkanet.thebartender

import android.app.Application
import com.mrkanet.thebartender.di.initKoin
import org.koin.android.ext.koin.androidContext

class BartenderAndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BartenderAndroidApp)
        }
    }
}