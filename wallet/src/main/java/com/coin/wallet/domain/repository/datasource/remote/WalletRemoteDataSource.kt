package com.coin.wallet.domain.repository.datasource.remote

import com.coin.core.domain.model.Currency

interface WalletRemoteDataSource {
    fun getCurrencies(counterCurrency: String): Result<List<Currency>>
}