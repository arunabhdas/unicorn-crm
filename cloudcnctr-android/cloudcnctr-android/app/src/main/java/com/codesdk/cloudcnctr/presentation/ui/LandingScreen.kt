package com.codesdk.cloudcnctr.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codesdk.cloudcnctr.presentation.ui.theme.DeepBlue
import com.codesdk.cloudcnctr.presentation.ui.theme.PrimaryColor

/**
 * Created by Das on 2022-07-13.
 */
@Composable
fun LandingScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    // TODO-FIXME navController.navigate(Screen.DetailScreen.withArgs(text))
                    navController.navigate(Screen.MainScreen.route)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .background(PrimaryColor)
            ) {
                Text(text = "GetStarted")
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}

@Composable
@Preview
fun AuthenticationScreenPreview() {
    LandingScreen(navController = rememberNavController())
}