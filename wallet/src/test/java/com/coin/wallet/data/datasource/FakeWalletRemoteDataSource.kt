package com.coin.wallet.data.datasource

import com.coin.core.domain.model.Currency
import com.coin.wallet.domain.repository.datasource.remote.WalletRemoteDataSource
import java.math.BigDecimal

class FakeWalletRemoteDataSource : WalletRemoteDataSource {

    override fun getCurrencies(counterCurrency: String): Result<List<Currency>> {
        return Result.success(USD_COUNTER_DEFAULT_CURRENCIES)
    }

    companion object {
        val USD_COUNTER_DEFAULT_CURRENCIES = listOf(
            Currency(
                "Litecoin", "icon", "LTC", "USD", BigDecimal.valueOf(1), BigDecimal.valueOf(2)
            ),
            Currency(
                "Binance USD", "icon", "BUSD", "USD", BigDecimal.valueOf(3), BigDecimal.valueOf(4)
            )
        )
    }
}