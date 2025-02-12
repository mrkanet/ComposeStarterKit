package com.mrkanet.thebartender

import androidx.compose.ui.window.ComposeUIViewController
import com.mrkanet.thebartender.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }