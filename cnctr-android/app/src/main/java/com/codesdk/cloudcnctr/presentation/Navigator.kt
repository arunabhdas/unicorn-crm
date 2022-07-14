package com.codesdk.cloudcnctr.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.codesdk.cloudcnctr.common.Constants
import com.codesdk.cloudcnctr.presentation.ui.*

/**
 * Created by Das on 2022-07-13.
 */
@Composable
fun Navigator() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.AuthenticationScreen.route
    ) {
        composable(route = Screen.AuthenticationScreen.route) {
            AuthenticationScreen(navController = navController)
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
           DetailScreen(name = entry.arguments?.getString(Constants.ARG_NAME))
        }

        composable(route = Screen.MainScreen.route) {
            MainScreen(name = "main_screen", navController = navController)
        }




    }
}


