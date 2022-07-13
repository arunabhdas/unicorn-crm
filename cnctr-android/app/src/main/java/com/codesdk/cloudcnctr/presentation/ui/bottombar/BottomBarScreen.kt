package com.codesdk.cloudcnctr.presentation.ui.bottombar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codesdk.cloudcnctr.presentation.ui.BottomMenuItem
import com.codesdk.cloudcnctr.presentation.ui.theme.AquaBlue
import com.codesdk.cloudcnctr.presentation.ui.theme.ButtonBlue
import com.codesdk.cloudcnctr.presentation.ui.theme.DeepBlue
import com.codesdk.cloudcnctr.R

/**
 * Created by Das on 2022-07-08.
 */
sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @DrawableRes val iconId: Int
) {
    object TabOneScreen: BottomBarScreen(
        route = "one",
        title = "Home",
        iconId = R.drawable.ic_bubble
    )

    object TabTwoScreen: BottomBarScreen(
        route = "two",
        title = "Profile",
        iconId = R.drawable.ic_profile

    )

    object TabThreeScreen: BottomBarScreen(
        route = "three",
        title = "Settings",
        iconId = R.drawable.ic_bubble
    )

    object CryptoListScreen: BottomBarScreen(
        route = "four",
        title = "Assets",
        iconId = R.drawable.ic_bubble
    )

    object CryptoDetailScreen: BottomBarScreen(
        route = "five",
        title = "Five",
        iconId = R.drawable.ic_bubble
    )
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}
