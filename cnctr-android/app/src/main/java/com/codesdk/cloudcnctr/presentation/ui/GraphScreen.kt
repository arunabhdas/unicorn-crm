package com.codesdk.cloudcnctr.presentation.ui

/**
 * Created by Das on 2022-07-11.
 */
sealed class GraphScreen(val route: String) {
    object AuthenticationScreen: GraphScreen("authentication_screen")
    object DetailScreen: GraphScreen("detail_screen")
    object MainScreen: GraphScreen("main_screen")
    object CryptoListScreen: GraphScreen("crypto_list_screen")
    object CryptoDetailScreen: GraphScreen("crypto_detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)

            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
