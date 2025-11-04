package com.mrkanet.thebartender.di

import com.mrkanet.thebartender.dependencies.FirebaseRepository
import com.mrkanet.thebartender.dependencies.FirebaseRepositoryImpl
import com.mrkanet.thebartender.firebase.firebaseAuth
import com.mrkanet.thebartender.firebase.firestore
import com.mrkanet.thebartender.ui.home.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { firebaseAuth }
    single { firestore }
    singleOf(::FirebaseRepositoryImpl).bind<FirebaseRepository>()
    viewModel { HomeViewModel(get()) }
}