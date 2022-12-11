package com.coin.wallet.di

import com.coin.wallet.domain.interactor.GetCryptoCurrenciesUseCase
import com.coin.wallet.domain.repository.WalletRepository
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Provides
    fun bindGetCryptoCurrenciesUseCase(walletRepository: WalletRepository): GetCryptoCurrenciesUseCase {
        return GetCryptoCurrenciesUseCase(walletRepository)
    }
}