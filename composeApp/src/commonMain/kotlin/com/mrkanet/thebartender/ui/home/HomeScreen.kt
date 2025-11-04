@file:OptIn(KoinExperimentalAPI::class)

package com.mrkanet.thebartender.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mrkanet.thebartender.di.modules.DrinkImage
import com.mrkanet.thebartender.ui.views.Comment
import com.mrkanet.thebartender.ui.views.FeedItemLikesAndComments
import com.mrkanet.thebartender.ui.views.FeedListItem
import com.mrkanet.thebartender.ui.views.HomeFeedView
import com.mrkanet.thebartender.ui.views.MediaItem
import com.mrkanet.thebartender.ui.views.MediaType
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.isUserLoggedIn.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Text("Home")
        Text(
            "Is user logged in: ${if (state) "Yes" else "No"}",
            modifier = Modifier.clickable { viewModel.logUserIn() })
        DrinkCard()
        /*
        HomeFeedView(
            data = listOf(
                FeedListItem(
                    type = MediaType.RECIPE,
                    medias = listOf(
                        MediaItem(
                            type = "image",
                            url = "https://www.thecocktaildb.com/images/media/drink/vrwquq1478252802.jpg"
                        )
                    ),
                    title = "Yeni tarifim nasıl?",
                    userName = "mrkanet",
                    likesAndComments = FeedItemLikesAndComments(
                        likeCount = 100,
                        commentCount = 4,
                        comments = listOf(
                            Comment(userName = "mrkanet", comment = "Bu tarif çok güzel"),
                            Comment(userName = "test", comment = "Bu tarif çok güzel"),
                            Comment(userName = "hello", comment = "Bu tarif çok güzel"),
                            Comment(userName = "zuck", comment = "Bu tarif çok güzel")
                        )
                    )
                )
            )
        )
         */
    }
}

@Composable
fun DrinkCard() {
    Column {
        DrinkImage(
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vrwquq1478252802.jpg",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text("TESADASD ASd sad asdsad öaşSÖ das D")
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}