package com.umuieme.astroglance.data.remote.api

import com.umuieme.astroglance.domain.model.ApodModel
import retrofit2.http.GET

interface NasaApi {
    @GET("planetary/apod?api_key=DEMO_KEY&start_date=2026-1-1")
    suspend fun getApod(): List<ApodModel>
}