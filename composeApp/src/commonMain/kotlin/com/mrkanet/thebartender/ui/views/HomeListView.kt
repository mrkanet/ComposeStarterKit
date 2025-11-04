package com.mrkanet.thebartender.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeFeedView(data: List<FeedListItem>) {
    Column {
        data.forEach {
            HomeFeedItem(data = it)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeFeedItem(data: FeedListItem) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // 1. Username
        Box(
            modifier = Modifier.fillMaxWidth().height(32.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = data.userName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        // 2. Medyalar (Yatay Pager)
        val pagerState = rememberPagerState(pageCount = { data.medias.size })
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) { page ->
            val media = data.medias[0]
            // Burada video ve görsel ayrımı yapılabilir. Şimdilik sadece görsel gösteriliyor.
            AsyncImage(
                model = media.url,
                contentDescription = data.title,
                modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 100.dp),
                onSuccess = { println("KAANTEST: IMAGE CACHE SUCCEED") },
                onLoading = { println("KAANTEST: IMAGE CACHE LOADING") },
                onError = { println("KAANTEST: IMAGE CACHE FAILED - ${it.result}") },
            )
            println("KAANTEST: IMAGE CACHE CALLED - ${media.url}")
        }

        // 3. Bilgiler (Kullanıcı adı, Beğeni, Yorum Sayısı)
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = data.title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "${data.likesAndComments.likeCount} Beğeni", fontSize = 14.sp)
                Text(text = "${data.likesAndComments.commentCount} Yorum", fontSize = 14.sp)
            }
        }

        // 4. İlk Yorum
        data.likesAndComments.comments.firstOrNull()?.let { firstComment ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = firstComment.userName, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(text = firstComment.comment, fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
fun HomeFeedPreview() {
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
}


data class FeedListItem(
    val type: MediaType,
    val medias: List<MediaItem>,
    val title: String,
    val userName: String,
    val likesAndComments: FeedItemLikesAndComments
)

data class FeedItemLikesAndComments(
    val likeCount: Int,
    val commentCount: Int,
    val comments: List<Comment>
)

data class Comment(val userName: String, val comment: String)
data class MediaItem(val type: String, val url: String)

enum class MediaType {
    RECIPE, POST, VIDEO;
}
