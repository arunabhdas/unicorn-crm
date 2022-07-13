package com.codesdk.cloudcnctr.domain.use_case.get_crypto

import com.codesdk.cloudcnctr.common.Resource
import com.codesdk.cloudcnctr.data.remote.dto.toCrypto
import com.codesdk.cloudcnctr.data.remote.dto.toCryptoDetail
import com.codesdk.cloudcnctr.data.repository.CryptoRepository
import com.codesdk.cloudcnctr.domain.model.Crypto
import com.codesdk.cloudcnctr.domain.model.CryptoDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Das on 2022-07-11.
 */
class GetCryptoUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CryptoDetail>> = flow {
        try {
            emit(Resource.Loading())
            val crypto = repository.getCryptoById(coinId).toCryptoDetail()
            android.util.Log.d("TODO-FIXME", "GetCryptoUseCase--crypto --" + coinId)
            emit(Resource.Success(crypto))

        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check internet connection"))
        }
    }

}