package com.codesdk.cloudcnctr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codesdk.cloudcnctr.presentation.ui.Screen
import com.codesdk.cloudcnctr.presentation.ui.CryptoListScreen
import com.codesdk.cloudcnctr.presentation.ui.CryptoDetailScreen

import com.codesdk.cloudcnctr.presentation.ui.theme.CloudCnctrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudCnctrTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(
                            route = Screen.CryptoListScreen.route
                        ) {
                            CryptoListScreen(navController)
                        }
                        composable(
                            route = Screen.CryptoDetailScreen.route + "/{cryptoId}"
                        ) {
                            CryptoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}