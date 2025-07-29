package com.mrkanet.thebartender.di

import com.mrkanet.thebartender.firebase.initializeFirebase
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    initializeFirebase()
    startKoin {
        config?.invoke(this)
        modules(sharedModule, platformModule)
    }
}
