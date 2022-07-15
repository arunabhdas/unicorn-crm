package ai.cloudcnctr.cloudcnctr.presentation.ui

/**
 * Created by Das on 2022-07-11.
 */
sealed class Screen(val route: String) {
    object AuthenticationScreen: Screen("authentication_screen")
    object DetailScreen: Screen("detail_screen")
    object MainScreen: Screen("main_screen")
    object CryptoListScreen: Screen("crypto_list_screen")
    object CryptoDetailScreen: Screen("crypto_detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)

            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
