package com.codesdk.cloudcnctr.domain.repository

import com.codesdk.cloudcnctr.data.remote.dto.CryptoDetailDto
import com.codesdk.cloudcnctr.data.remote.dto.CryptoDto

/**
 * Created by Das on 2022-07-11.
 */
interface CryptoRepository {

    suspend fun getCryptos() : List<CryptoDto>

    suspend fun getCryptoById(coinId: String) : CryptoDetailDto
}