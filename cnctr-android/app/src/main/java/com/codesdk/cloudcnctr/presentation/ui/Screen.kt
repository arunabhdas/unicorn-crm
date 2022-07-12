package com.codesdk.cloudcnctr.presentation.ui

/**
 * Created by Das on 2022-07-11.
 */
sealed class Screen(val route: String) {
    object CryptoListScreen: Screen("crypto_list_screen")
    object CryptoDetailScreen: Screen("crypto_detail_screen")
}
