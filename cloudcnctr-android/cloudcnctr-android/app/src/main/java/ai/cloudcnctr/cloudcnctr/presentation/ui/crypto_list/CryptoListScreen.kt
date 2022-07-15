package ai.cloudcnctr.cloudcnctr.presentation.ui

import ai.cloudcnctr.cloudcnctr.presentation.ui.theme.DeepBlue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ai.cloudcnctr.cloudcnctr.presentation.ui.crypto_list.components.CryptoListViewModel
import ai.cloudcnctr.cloudcnctr.presentation.ui.crypto_list.components.CryptoListItem
import ai.cloudcnctr.cloudcnctr.presentation.ui.theme.DeepBlue

/**
 * Created by Das on 2022-07-11.
 */
@Composable
fun CryptoListScreen(
    navController: NavController,
    viewModel: CryptoListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.cryptos) { crypto ->
                CryptoListItem(
                    crypto = crypto,
                    onItemClick = {
                        android.util.Log.d("TODO-FIXME", "CryptoListScreen-onItemClick----------/${crypto.id}")
                        navController.navigate(
                            Screen.CryptoDetailScreen.route + "/${crypto.id}"
                        )
                })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}

@Composable
@Preview
fun CryptoListScreenPreview() {
    // TODO-FIXME-x86 CryptoListScreen()
}