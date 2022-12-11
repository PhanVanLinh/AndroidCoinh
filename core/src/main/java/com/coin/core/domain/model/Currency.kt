package com.coin.core.domain.model

import java.math.BigDecimal

data class Currency(
    val name: String,
    val icon: String,
    val base: String,
    val counter: String,
    val buyPrice: BigDecimal,
    val sellPrice: BigDecimal,
)