package com.inmersoft.trinidadpatrimonialkmm.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Route(
    val headerImages: List<ImageBlur>,
    val placesId: List<Int>,
    val description: String,
    val id: Long,
    val name: String,
    val video: String,
    val web: String,
)
