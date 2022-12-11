package com.coin.wallet.ui.wallet.model

import com.coin.core.domain.model.Currency
import java.math.BigDecimal

data class CurrencyModel(
    val name: String,
    val icon: String,
    val base: String,
    val counter: String,
    val buyPrice: BigDecimal,
    val sellPrice: BigDecimal,
) {
    companion object {
        fun fromCurrency(currency: Currency): CurrencyModel {
            return CurrencyModel(
                currency.name,
                currency.icon,
                currency.base,
                currency.counter,
                currency.buyPrice,
                currency.sellPrice
            )
        }
    }
}