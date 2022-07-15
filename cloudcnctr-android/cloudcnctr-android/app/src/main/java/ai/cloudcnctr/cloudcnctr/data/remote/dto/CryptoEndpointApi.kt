package ai.cloudcnctr.cloudcnctr.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Das on 2022-07-11.
 */
interface CryptoEndpointApi {

    @GET("/v1/coins")
    suspend fun getCryptos(): List<CryptoDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCryptoById(@Path("coinId") coinId: String): CryptoDetailDto

}