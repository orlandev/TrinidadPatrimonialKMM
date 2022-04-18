package com.inmersoft.trinidadpatrimonialkmm.domain.models.events

import com.inmersoft.trinidadpatrimonialkmm.domain.models.ImageBlur
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.Content
import kotlinx.serialization.Serializable

@Serializable
data class EventModel(
    val eventId: Int,
    val content: List<Content>,
    val headerImage: ImageBlur,
    val date: Long,
    val subtitle: String,
    val title: String,
    val start: Long,
    val end: Long,
    val location: String
)