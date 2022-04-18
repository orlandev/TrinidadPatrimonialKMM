package com.inmersoft.trinidadpatrimonialkmm.domain.models.news

import com.inmersoft.trinidadpatrimonialkmm.domain.models.ImageBlur
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.Content
import kotlinx.serialization.Serializable

@Serializable
data class NewsModel(
    val newsId: Int,
    val content: List<Content>,
    val headerImage: ImageBlur,
    val date: Long,
    val subtitle: String,
    val title: String
)