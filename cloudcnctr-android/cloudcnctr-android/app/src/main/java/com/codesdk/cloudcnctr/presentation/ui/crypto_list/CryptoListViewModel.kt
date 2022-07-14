package com.codesdk.cloudcnctr.presentation.ui.crypto_list.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesdk.cloudcnctr.common.Resource
import com.codesdk.cloudcnctr.domain.model.Crypto
import com.codesdk.cloudcnctr.domain.use_case.get_crypto.GetCryptoUseCase
import com.codesdk.cloudcnctr.domain.use_case.get_cryptos.GetCryptosUseCase
import com.codesdk.cloudcnctr.presentation.ui.crypto_list.CryptoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Das on 2022-07-11.
 */
@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCryptosUseCase: GetCryptosUseCase

) : ViewModel() {
    private val _state = mutableStateOf(CryptoListState())
    val state: State<CryptoListState> = _state

    init {
        getCryptos()
    }
    private fun getCryptos() {
        getCryptosUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CryptoListState(cryptos = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CryptoListState(
                        error = result.message ?: "Unexpected error"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CryptoListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

