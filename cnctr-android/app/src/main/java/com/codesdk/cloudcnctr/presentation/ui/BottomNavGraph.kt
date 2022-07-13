package com.codesdk.cloudcnctr.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codesdk.cloudcnctr.presentation.ui.bottombar.BottomBarScreen

/**
 * Created by Das on 2022-07-08.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController) {
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

        composable(route = BottomBarScreen.CryptoDetailScreen.route) {
            CryptoDetailScreen()
        }
    }
}