@file:OptIn(KoinExperimentalAPI::class)

package com.mrkanet.thebartender

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mrkanet.thebartender.bases.TopBar
import com.mrkanet.thebartender.ui.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@Preview
fun App() {
    MaterialTheme {
        var title by remember { mutableStateOf("Home") }
        var isBackEnable by remember { mutableStateOf(false) }
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars),
            topBar = {
                TopBar(
                    isBackEnable = isBackEnable,
                    title = title,
                    onBack = null
                )
            },
            bottomBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    IconButton(
                        onClick = {
                            title = "Search"
                            isBackEnable = false
                            navController.navigate("search")
                        },
                        modifier = Modifier,
                        enabled = title != "Search",
                        interactionSource = null,
                        content = {
                            Icon(Icons.Default.Search, contentDescription = null)
                        }
                    )
                    IconButton(
                        onClick = {
                            title = "Home"
                            isBackEnable = false
                            navController.navigate("home")
                        },
                        modifier = Modifier,
                        enabled = title != "Home",
                        interactionSource = null,
                        content = {
                            Icon(Icons.Default.Home, contentDescription = null)
                        }
                    )
                    IconButton(
                        onClick = {
                            title = "Profile"
                            isBackEnable = false
                            navController.navigate("profile")
                        },
                        modifier = Modifier,
                        enabled = title != "Profile",
                        interactionSource = null,
                        content = {
                            Icon(Icons.Default.Person, contentDescription = null)
                        }
                    )
                }
            },
            content = { pd ->
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.padding(pd)
                ) {
                    composable("home") {
                        HomeScreen()
                    }
                    composable("search") {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text("Search")
                        }
                    }
                    composable("profile") {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text("Profile")
                        }
                    }
                }
            }
        )
    }
}

/*
@Composable
@Preview
fun App() {
    var title by remember { mutableStateOf("Home") }
    var isBackEnable by remember { mutableStateOf(false) }
    MaterialTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar(
                    isBackEnable = isBackEnable,
                    title = title,
                    onBack = null
                )
            },
            bottomBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    IconButton(
                        onClick = {
                            title = "Search"
                            isBackEnable = false
                            navController.navigate("search")
                        },
                        modifier = Modifier,
                        enabled = title != "Search",
                        interactionSource = null,
                        content = {
                            Icon(Icons.Default.Search, contentDescription = null)
                        }
                    )
                    IconButton(
                        onClick = {
                            title = "Home"
                            isBackEnable = false
                            navController.navigate("home")
                        },
                        modifier = Modifier,
                        enabled = title != "Home",
                        interactionSource = null,
                        content = {
                            Icon(Icons.Default.Home, contentDescription = null)
                        }
                    )
                    IconButton(
                        onClick = {
                            title = "Profile"
                            isBackEnable = false
                            navController.navigate("profile")
                        },
                        modifier = Modifier,
                        enabled = title != "Profile",
                        interactionSource = null,
                        content = {
                            Icon(Icons.Default.Person, contentDescription = null)
                        }
                    )
                }
            },
            content = { pd ->
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        val viewModel = viewModel<HomeViewModel>()
                        val state by viewModel.isUserLoggedIn.collectAsState()

                        Column(modifier = Modifier.fillMaxSize()) {
                            Text("Home")
                            Text("Is user logged in: ${if (state) "Yes" else "No"}")
                        }
                    }
                    composable("search") {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text("Search")
                        }
                    }
                    composable("profile") {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text("Profile")
                        }
                    }
                }
            }
        )
    }
}
*/