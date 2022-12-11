package com.coin.wallet.di

import android.content.Context
import com.coin.wallet.ui.wallet.WalletActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [NetworkModule::class, UseCaseModule::class, RepositoryModule::class])
interface LoginComponent {

  fun inject(activity: WalletActivity)

  @Component.Builder
  interface Builder {
    fun context(@BindsInstance context: Context): Builder
    fun networkModule(networkModule: NetworkModule): Builder
    fun useCaseModule(useCaseModule: UseCaseModule): Builder
    fun repositoryModule(repositoryModule: RepositoryModule): Builder
    fun build(): LoginComponent
  }
}