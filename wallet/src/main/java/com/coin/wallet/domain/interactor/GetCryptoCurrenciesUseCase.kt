package com.coin.wallet.domain.interactor

import com.coin.core.domain.interactor.UseCase
import com.coin.core.domain.model.Currency
import com.coin.wallet.domain.repository.WalletRepository
import com.coin.core.domain.data.Result

class GetCryptoCurrenciesUseCase(private val walletRepository: WalletRepository) :
    UseCase<GetCryptoCurrenciesUseCase.Input, List<Currency>>() {

    override suspend fun invoke(input: Input): Result<List<Currency>> {
        return walletRepository.getCurrencies(input.counterCurrency)
    }

    data class Input(
        val counterCurrency: String,
    ) : UseCase.Input()
}