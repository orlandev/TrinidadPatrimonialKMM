package com.inmersoft.trinidadpatrimonialkmm.domain.models.content

import kotlinx.serialization.Serializable

@Serializable
data class TextContent(
    val content: List<Content>,
    val id: String
)
