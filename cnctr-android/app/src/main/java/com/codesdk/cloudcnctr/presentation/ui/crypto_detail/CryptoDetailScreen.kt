package com.codesdk.cloudcnctr.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codesdk.cloudcnctr.common.Constants
import com.codesdk.cloudcnctr.presentation.ui.crypto_detail.components.CryptoTag
import com.codesdk.cloudcnctr.presentation.ui.crypto_detail.components.MoreInfoListItem
import com.codesdk.cloudcnctr.presentation.ui.crypto_list.components.CryptoDetailViewModel
import com.codesdk.cloudcnctr.presentation.ui.crypto_list.components.CryptoListViewModel
import com.codesdk.cloudcnctr.presentation.ui.crypto_list.components.CryptoListItem
import com.codesdk.cloudcnctr.presentation.ui.theme.DeepBlue
import com.google.accompanist.flowlayout.FlowRow

/**
 * Created by Das on 2022-07-11.
 */
@Composable
fun CryptoDetailScreen(
    viewModel: CryptoDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {

        state.crypto?.let { crypto ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${crypto.rank} . ${crypto.name} ${crypto.symbol}",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )

                        Text(
                            text = if (crypto.isActive) Constants.STATUS_ACTIVE else Constants.STATUS_INACTIVE,
                            color = if (crypto.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = crypto.description,
                            style = MaterialTheme.typography.body2
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                       Text(
                           text = "Tags",
                           style = MaterialTheme.typography.h3
                       )

                        Spacer(modifier = Modifier.height(15.dp))

                        FlowRow(
                            mainAxisSpacing = 10.dp,
                            crossAxisSpacing = 10.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            crypto.tags.forEach { tag ->
                                CryptoTag(tag = tag)
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Members",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    /* TODO-FIXME
                    items(crypto.team) { teamMember ->
                        MoreInfoListItem(
                            moreInfoItemMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                       Divider()
                    }
                    */
                }

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
fun CryptoDetailScreenPreview() {
    // TODO-FIXME-x86 CryptoListScreen()
}