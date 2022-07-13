package com.codesdk.cloudcnctr.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.codesdk.cloudcnctr.common.Constants
import com.codesdk.cloudcnctr.presentation.ui.bottombar.BottomBarScreen

/**
 * Created by Das on 2022-07-08.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.TabOneScreen.route
    ) {
        composable(route = BottomBarScreen.TabOneScreen.route) {
            TabOneScreen()
        }

        composable(route = BottomBarScreen.TabTwoScreen.route) {
            TabTwoScreen()
        }

        composable(route = BottomBarScreen.TabThreeScreen.route) {
            TabThreeScreen()
        }

        composable(route = BottomBarScreen.CryptoListScreen.route) {
            CryptoListScreen(navController)
        }

        /* TODO-FIXME
        composable(route = BottomBarScreen.CryptoDetailScreen.route) {
            CryptoDetailScreen()
        }
        */
        composable(
            route = GraphScreen.CryptoDetailScreen.route + "/{arg_name}",
            arguments = listOf(
                navArgument(Constants.PARAM_CRYPTO_ID) {
                    type = NavType.StringType
                    defaultValue = "eth-ethereum"
                    nullable = true
                }
            )
        ) { entry ->
            CryptoDetailScreen(
                // TODO-FIXME name = entry.arguments?.getString(Constants.PARAM_CRYPTO_ID)
                name = "/{arg_name}"
            )
        }
    }
}