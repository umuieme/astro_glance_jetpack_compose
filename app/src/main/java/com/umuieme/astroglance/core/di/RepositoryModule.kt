package com.umuieme.astroglance.core.di

import com.umuieme.astroglance.data.repository.ApodRepositoryImpl
import com.umuieme.astroglance.domain.repository.ApodRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindApiRepository(
        apodRepositoryImpl: ApodRepositoryImpl
    ) : ApodRepository
}