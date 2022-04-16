package com.inmersoft.trinidadpatrimonialkmm.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageBlur(
    val blurHash: String,
    val url: String
)
