package com.umuieme.astroglance.core.di

import com.umuieme.astroglance.data.remote.api.NasaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNasaApi(): NasaApi {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(NasaApi::class.java)
    }
}
