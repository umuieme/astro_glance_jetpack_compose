package com.umuieme.astroglance.data.remote.api

import com.umuieme.astroglance.BuildConfig
import com.umuieme.astroglance.domain.model.ApodModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("planetary/apod")
    suspend fun getApod(
        @Query("api_key") apiKey: String = BuildConfig.NASA_API_KEY,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): List<ApodModel>
}
