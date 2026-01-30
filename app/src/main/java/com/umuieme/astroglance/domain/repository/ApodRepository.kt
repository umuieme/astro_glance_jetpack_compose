package com.umuieme.astroglance.domain.repository

import com.umuieme.astroglance.domain.model.ApodModel

interface ApodRepository {
    suspend fun getApod(): List<ApodModel>
}