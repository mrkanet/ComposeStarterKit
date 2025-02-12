package com.mrkanet.thebartender.di

import com.mrkanet.thebartender.dependencies.FirebaseRepository
import com.mrkanet.thebartender.dependencies.FirebaseRepositoryImpl
import com.mrkanet.thebartender.ui.home.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    singleOf(::FirebaseRepositoryImpl).bind<FirebaseRepository>()
    viewModelOf(::HomeViewModel)
}