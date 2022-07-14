package com.codesdk.cloudcnctr.data.repository

import com.codesdk.cloudcnctr.data.remote.dto.CryptoDetailDto
import com.codesdk.cloudcnctr.data.remote.dto.CryptoDto
import com.codesdk.cloudcnctr.data.remote.dto.CryptoEndpointApi
import javax.inject.Inject

/**
 * Created by Das on 2022-07-11.
 */

interface CryptoRepository {
    suspend fun getCryptos() : List<CryptoDto>
    suspend fun getCryptoById(coinId: String) : CryptoDetailDto
}

class CryptoRepositoryImpl @Inject constructor(

    private val api: CryptoEndpointApi
) : CryptoRepository {

    override suspend fun getCryptos(): List<CryptoDto> {
       return api.getCryptos()
    }

    override suspend fun getCryptoById(coinId: String): CryptoDetailDto {
        return api.getCryptoById(coinId)
    }
}