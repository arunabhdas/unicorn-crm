package com.codesdk.cloudcnctr.presentation.ui.crypto_list

import com.codesdk.cloudcnctr.domain.model.Crypto

/**
 * Created by Das on 2022-07-12.
 */
data class CryptoListState(
    val isLoading: Boolean = false,
    val cryptos: List<Crypto> = emptyList(),
    val error: String = ""
)