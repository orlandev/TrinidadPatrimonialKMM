package com.inmersoft.trinidadpatrimonialkmm.domain.models.content

import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentItem
import kotlinx.serialization.Serializable

@Serializable
data class ContentDTO(
    val content: List<ContentItem>
)