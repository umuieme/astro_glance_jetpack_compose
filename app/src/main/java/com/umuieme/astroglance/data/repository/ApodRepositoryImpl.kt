package com.umuieme.astroglance.data.repository

import com.umuieme.astroglance.data.remote.api.NasaApi
import com.umuieme.astroglance.domain.model.ApodModel
import com.umuieme.astroglance.domain.repository.ApodRepository
import javax.inject.Inject

class ApodRepositoryImpl @Inject constructor(private val api: NasaApi) : ApodRepository {
    override suspend fun getApod(): List<ApodModel> {
        return api.getApod()
    }
}