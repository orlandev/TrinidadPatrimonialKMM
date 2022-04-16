package com.inmersoft.trinidadpatrimonialkmm.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class PlaceType(
    val icon: String,
    val id: Long,
    val name: String,
    val classification: String
)

