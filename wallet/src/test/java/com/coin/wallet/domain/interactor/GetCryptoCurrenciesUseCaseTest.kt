package com.coin.wallet.domain.interactor

import com.coin.wallet.data.DefaultWalletRepository
import com.coin.wallet.data.datasource.FakeWalletRemoteDataSource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetCryptoCurrenciesUseCaseTest {

    @Test
    fun `when get crypto currencies list, should return the list from remote`() = runBlocking {
        val network = FakeWalletRemoteDataSource()
        val repository = DefaultWalletRepository(network)
        val useCase = GetCryptoCurrenciesUseCase(repository)
        val list = useCase.invoke(GetCryptoCurrenciesUseCase.Input("USD"))
        assertThat(list).isEqualTo(
            Result.success(FakeWalletRemoteDataSource.USD_COUNTER_DEFAULT_CURRENCIES)
        )
    }
}