package com.coin.wallet.domain.repository

import com.coin.core.domain.model.Currency

interface WalletRepository {
    fun getCurrencies(counterCurrency: String): Result<List<Currency>>
}