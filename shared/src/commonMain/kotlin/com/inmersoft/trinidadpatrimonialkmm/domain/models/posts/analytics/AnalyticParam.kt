package com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics

import kotlinx.serialization.Serializable


@Serializable
data class AnalyticParam(
    val paramName: EventParamType,
    val paramValue: String
)