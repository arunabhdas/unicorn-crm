package ai.cloudcnctr.cloudcnctr.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ai.cloudcnctr.cloudcnctr.R
import ai.cloudcnctr.cloudcnctr.presentation.ui.bottombar.BottomMenu
import ai.cloudcnctr.cloudcnctr.presentation.ui.bottombar.BottomMenuContent
import ai.cloudcnctr.cloudcnctr.presentation.ui.theme.Feature
import ai.cloudcnctr.cloudcnctr.presentation.ui.theme.*

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(PrimaryColor)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Frontend", "Backend", "Database"))
            CurrentBlock()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Frontend",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Backend",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Database",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Target Platform",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Design", R.drawable.ic_search),
            BottomMenuContent("Codegen", R.drawable.ic_bubble),
            BottomMenuContent("Test", R.drawable.ic_home),
            BottomMenuContent("Stage", R.drawable.ic_bubble),
            BottomMenuContent("Deploy", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}

