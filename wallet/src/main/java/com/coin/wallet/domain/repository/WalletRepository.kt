package com.coin.wallet.domain.repository

import com.coin.core.domain.model.Currency
import com.coin.core.domain.data.Result

interface WalletRepository {
    suspend fun getCurrencies(counterCurrency: String): Result<List<Currency>>
}