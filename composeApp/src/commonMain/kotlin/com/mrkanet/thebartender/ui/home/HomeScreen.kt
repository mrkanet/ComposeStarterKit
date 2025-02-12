@file:OptIn(KoinExperimentalAPI::class)

package com.mrkanet.thebartender.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.isUserLoggedIn.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Home")
        Text(
            "Is user logged in: ${if (state) "Yes" else "No"}",
            modifier = Modifier.clickable { viewModel.logUserIn() })
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}