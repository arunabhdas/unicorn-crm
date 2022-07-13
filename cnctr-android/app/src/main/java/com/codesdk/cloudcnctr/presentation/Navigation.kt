package com.codesdk.cloudcnctr.presentation

import android.telecom.Call.Details
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.codesdk.cloudcnctr.common.Constants
import com.codesdk.cloudcnctr.presentation.ui.DetailScreen
import com.codesdk.cloudcnctr.presentation.ui.LandingScreen
import com.codesdk.cloudcnctr.presentation.ui.MainScreen
import com.codesdk.cloudcnctr.presentation.ui.Screen

/**
 * Created by Das on 2022-07-13.
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LandingScreen.route
    ) {
        composable(route = Screen.LandingScreen.route) {
            LandingScreen(navController = navController)
        }

        composable(
            route = Screen.DetailScreen.route + "/{arg_name}",
            arguments = listOf(
                navArgument(Constants.ARG_NAME) {
                    type = NavType.StringType
                    defaultValue = "CloudCnctr"
                    nullable = true
                }
            )
        ) { entry ->
            // TODO-FIXME DetailScreen(name = entry.arguments?.getString(Constants.ARG_NAME))
            MainScreen(name = entry.arguments?.getString(Constants.ARG_NAME))
        }
    }
}


