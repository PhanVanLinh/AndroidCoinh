package com.coin.wallet.di

import com.coin.androidcoinh.BuildConfig.BASE_URL
import com.coin.wallet.data.datasource.remote.CoinhApi
import com.coin.wallet.data.datasource.remote.ServiceGenerator
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*

@EntryPoint
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Provides
    fun provideCoinhApi(
    ): CoinhApi {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val interceptors: Array<Interceptor> = arrayOf(loggingInterceptor)
        return ServiceGenerator.generate(
            BASE_URL,
            CoinhApi::class.java,
            null,
            interceptors
        )
    }
}