package com.umuieme.astroglance.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApodModel(
    val copyright: String? = null,
    val date: String,
    val explanation: String,
    @SerialName("hdurl") val hdUrl: String? = null,
    @SerialName("media_type") val mediaType: String,
    val title: String,
    val url: String? = null,
)