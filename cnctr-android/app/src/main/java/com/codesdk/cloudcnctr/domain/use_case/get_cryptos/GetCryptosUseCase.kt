package com.codesdk.cloudcnctr.domain.use_case.get_cryptos

import com.codesdk.cloudcnctr.common.Resource
import com.codesdk.cloudcnctr.data.remote.dto.toCrypto
import com.codesdk.cloudcnctr.data.repository.CryptoRepository
import com.codesdk.cloudcnctr.domain.model.Crypto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Das on 2022-07-11.
 */
class GetCryptosUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    operator fun invoke(): Flow<Resource<List<Crypto>>> = flow {
        try {
            emit(Resource.Loading<List<Crypto>>())
            val cryptos = repository.getCryptos().map { it.toCrypto() }
            emit(Resource.Success<List<Crypto>>(cryptos))

        } catch(e: HttpException) {
            emit(Resource.Error<List<Crypto>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Crypto>>("Couldn't reach server. Check internet connection"))
        }
    }

}