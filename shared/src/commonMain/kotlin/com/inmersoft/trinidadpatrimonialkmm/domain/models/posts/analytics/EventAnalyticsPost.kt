package com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics

import kotlinx.serialization.Serializable

@Serializable
data class EventAnalyticsPost(
    val id: EventType,
    val analyticParams: List<AnalyticParam>
)


