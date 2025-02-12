package com.mrkanet.thebartender.di

import com.mrkanet.thebartender.dependencies.DBClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::DBClient)
}