package ai.cloudcnctr.cloudcnctr.presentation.ui.crypto_detail

import ai.cloudcnctr.cloudcnctr.domain.model.CryptoDetail

/**
 * Created by Das on 2022-07-12.
 */
data class CryptoDetailState(
    val isLoading: Boolean = false,
    val crypto: CryptoDetail? = null,
    val error: String = ""
)