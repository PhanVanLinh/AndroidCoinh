package com.coin.wallet.ui.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coin.wallet.domain.interactor.GetCryptoCurrenciesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import com.coin.core.domain.data.Result
import com.coin.wallet.R
import com.coin.wallet.ui.wallet.model.CurrencyModel
import kotlinx.coroutines.launch

class WalletViewModel(val getCryptoCurrenciesUseCase: GetCryptoCurrenciesUseCase) : ViewModel() {

    private val _walletUiState = MutableStateFlow(WalletUiState(loading = true))
    val walletUiState: SharedFlow<WalletUiState> = _walletUiState

    fun getCryptoCurrencies(counterCurrency: String) {
        viewModelScope.launch {
            _walletUiState.emit(WalletUiState(loading = true))
            val result = getCryptoCurrenciesUseCase(
                GetCryptoCurrenciesUseCase.Input(counterCurrency)
            )
            when (result) {
                is Result.Success -> {
                    _walletUiState.emit(
                        WalletUiState(success = result.data.map {
                            CurrencyModel.fromCurrency(it)
                        })
                    )
                }
                is Result.NetworkError -> {
                    _walletUiState.emit(WalletUiState(error = R.string.wallet_error_network))
                }
                is Result.UnknownError -> {
                    _walletUiState.emit(WalletUiState(error = R.string.wallet_error_failed_to_fetch_data))
                }
            }
        }
    }
}