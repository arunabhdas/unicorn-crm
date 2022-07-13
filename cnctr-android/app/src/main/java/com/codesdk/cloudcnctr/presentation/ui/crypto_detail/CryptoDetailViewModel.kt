package com.codesdk.cloudcnctr.presentation.ui.crypto_list.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesdk.cloudcnctr.common.Constants
import com.codesdk.cloudcnctr.common.Resource
import com.codesdk.cloudcnctr.domain.model.Crypto
import com.codesdk.cloudcnctr.domain.model.CryptoDetail
import com.codesdk.cloudcnctr.domain.use_case.get_crypto.GetCryptoUseCase
import com.codesdk.cloudcnctr.domain.use_case.get_cryptos.GetCryptosUseCase
import com.codesdk.cloudcnctr.presentation.ui.crypto_detail.CryptoDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Das on 2022-07-11.
 */
@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val getCryptoUseCase: GetCryptoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CryptoDetailState())
    val state: State<CryptoDetailState> = _state

    init {
        android.util.Log.d("TODO-FIXME", "CryptoDetailViewModel init")
        savedStateHandle.get<String>(Constants.PARAM_CRYPTO_ID)?.let {coinId ->
            android.util.Log.d("TODO-FIXME", "CryptoDetailViewModel init-" + coinId)
            getCrypto(coinId)
        }
    }
    private fun getCrypto(coinId: String) {
        getCryptoUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    android.util.Log.d("TODO-FIXME", "CryptoDetailViewModel success")
                    _state.value = CryptoDetailState(crypto = result.data)
                }

                is Resource.Error -> {
                    android.util.Log.d("TODO-FIXME", "CryptoDetailViewModel error")
                    _state.value = CryptoDetailState(
                        error = result.message ?: "Unexpected error"
                    )
                }

                is Resource.Loading -> {
                    android.util.Log.d("TODO-FIXME", "CryptoDetailViewModel loading")
                    _state.value = CryptoDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

