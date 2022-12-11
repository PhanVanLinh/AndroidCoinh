package com.coin.wallet.domain.repository.datasource.remote

import com.coin.core.domain.model.Currency
import com.coin.core.domain.data.Result


interface WalletRemoteDataSource {
    suspend fun getCurrencies(counterCurrency: String): Result<List<Currency>>
}