package com.codesdk.cloudcnctr.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codesdk.cloudcnctr.presentation.ui.crypto_list.components.CryptoListViewModel
import com.codesdk.cloudcnctr.presentation.ui.cryptos_list.components.CryptoListItem
import com.codesdk.cloudcnctr.presentation.ui.theme.DeepBlue

/**
 * Created by Das on 2022-07-11.
 */

@Composable
fun TabFourScreen(
    navController: NavController,
    viewModel: CryptoListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Assets",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
@Preview
fun TabFourScreenPreview() {
    // TODO-FIXME-x86 TabFourScreen()
}