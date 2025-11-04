package com.mrkanet.thebartender.bases

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun TopBar(
    isBackEnable: Boolean,
    title: String,
    isMenuEnable: Boolean = false,
    onBack: (() -> Unit)? = null,
    menuItems: List<MenuItems>? = null
) {
    Column {
        Spacer(modifier = Modifier.padding(4.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            if (isBackEnable) {
                Icon(
                    Icons.Outlined.KeyboardArrowUp,
                    modifier = Modifier.rotate(-90f).align(Alignment.CenterStart)
                        .clickable { onBack?.invoke() },
                    contentDescription = null
                )
            }
            Text(
                title,
                modifier = Modifier,
                textAlign = TextAlign.Center
            )
            if (isMenuEnable && menuItems?.isNotEmpty() == true) {
                Icon(
                    menuItems[0].icon,
                    modifier = Modifier.rotate(90f).align(Alignment.CenterEnd)
                        .clickable { menuItems[0].onClick?.invoke() },
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
    }
}

data class MenuItems(val icon: Painter, val title: String, val onClick: (() -> Unit)? = null)