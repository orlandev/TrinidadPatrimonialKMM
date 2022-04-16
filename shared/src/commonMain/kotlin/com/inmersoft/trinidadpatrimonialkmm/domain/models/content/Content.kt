package com.inmersoft.trinidadpatrimonialkmm.domain.models.content

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val `field`: String,
    val type: String,
)



