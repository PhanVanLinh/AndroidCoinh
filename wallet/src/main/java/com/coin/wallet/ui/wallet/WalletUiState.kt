package com.coin.wallet.ui.wallet

import com.coin.wallet.ui.wallet.model.CurrencyModel

class WalletUiState(
    val loading: Boolean? = null,
    val success: List<CurrencyModel>? = null,
    val error: Int? = null
)