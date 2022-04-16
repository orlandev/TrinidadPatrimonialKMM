package com.inmersoft.trinidadpatrimonialkmm.domain.models.review

import kotlinx.serialization.Serializable

@Serializable
data class ReviewPost(
    val id: Int,
    val stars: Int,
    val comment: String,
    val collection: String
)

