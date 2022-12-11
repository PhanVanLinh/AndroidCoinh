package com.coin.wallet.data.datasource.remote

import com.coin.core.domain.model.Currency
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinhApi {
    @GET("/api/v3/price/all_prices_for_mobile")
    suspend fun getSurveyList(
        @Query("counter_currency") counterCurrency: String
    ): List<Currency>
}