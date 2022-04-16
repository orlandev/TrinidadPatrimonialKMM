package com.inmersoft.trinidadpatrimonialkmm.domain.models

import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.Content
import kotlinx.serialization.Serializable

@Serializable
data class Place(
    val id: Long,
    val name: String,
    val description: String,
    val headerImages: List<ImageBlur>,
    val location: String,
    val model3d: String = "",
    val stars: Double,
    val comments: List<String>,
    val placeType: List<Int>,
    val video: String,
    val routes: List<Int>,
    val pano: String,
    val web: String,
    val content: List<Content>,
)
