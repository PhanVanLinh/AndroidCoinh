package com.coin.wallet.data.datasource.remote

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ServiceGenerator {

    companion object {

        private const val CONNECTION_TIMEOUT = 15L

        fun <T> generate(
            baseUrl: String, serviceClass: Class<T>,
            authenticator: Authenticator?,
            interceptors: Array<Interceptor>
        ): T {
            val okHttpClientBuilder = OkHttpClient().newBuilder()

            for (interceptor in interceptors) {
                okHttpClientBuilder.addInterceptor(interceptor)
            }
            okHttpClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            if (authenticator != null) {
                okHttpClientBuilder.authenticator(authenticator)
            }
            val okHttpClient = okHttpClientBuilder.build()

            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
            return retrofit.create(serviceClass)
        }
    }
}