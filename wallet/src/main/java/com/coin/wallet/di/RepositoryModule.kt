package com.coin.wallet.di

import com.coin.wallet.data.DefaultWalletRepository
import com.coin.wallet.data.datasource.remote.DefaultWalletRemoteDataSource
import com.coin.wallet.domain.repository.WalletRepository
import com.coin.wallet.domain.repository.datasource.remote.WalletRemoteDataSource
import dagger.Binds
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    abstract fun bindDefaultWalletRemoteDataSource(
        d: DefaultWalletRemoteDataSource
    ): WalletRemoteDataSource

    @Binds
    abstract fun bindAuthRepository(
        d: DefaultWalletRepository
    ): WalletRepository
}