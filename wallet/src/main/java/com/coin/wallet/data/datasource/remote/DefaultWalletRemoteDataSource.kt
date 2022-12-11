package com.coin.wallet.data.datasource.remote

import com.coin.core.domain.data.Result
import com.coin.core.domain.model.Currency
import com.coin.wallet.di.IODispatcher
import com.coin.wallet.domain.repository.datasource.remote.WalletRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.IOException

class DefaultWalletRemoteDataSource(
    private val coinhApi: CoinhApi,
    @IODispatcher
    val dispatcher: CoroutineDispatcher
) : WalletRemoteDataSource {

    override suspend fun getCurrencies(counterCurrency: String): Result<List<Currency>> {
        return withContext(dispatcher) {
            getResult {
                coinhApi.getSurveyList(counterCurrency)
            }
        }
    }

    private suspend fun <T> getResult(call: suspend () -> T): Result<T> {
        try {
            val response = call()
            return Result.Success(response)
        } catch (e: Exception) {
            if (e is IOException) {
                return Result.NetworkError
            }
            return Result.UnknownError(e)
        }
    }
}