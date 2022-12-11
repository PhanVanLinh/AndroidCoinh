package com.coin.wallet.data

import com.coin.core.domain.model.Currency
import com.coin.wallet.domain.repository.WalletRepository
import com.coin.wallet.domain.repository.datasource.remote.WalletRemoteDataSource
import com.coin.core.domain.data.Result

class DefaultWalletRepository(
    private val walletRemoteDataSource: WalletRemoteDataSource
) : WalletRepository {

    override fun getCurrencies(counterCurrency: String): Result<List<Currency>> {
        return walletRemoteDataSource.getCurrencies(counterCurrency)
    }
}