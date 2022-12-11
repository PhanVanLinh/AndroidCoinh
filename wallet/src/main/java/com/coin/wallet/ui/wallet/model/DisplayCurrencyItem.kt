package com.coin.wallet.ui.wallet.model

import java.math.BigDecimal

open class DisplayCurrencyItem
object LoadingItem : DisplayCurrencyItem()
data class CurrencyItem(
    val name: String,
    val icon: String,
    val base: String,
    val price: BigDecimal
) : DisplayCurrencyItem()