package com.inmersoft.trinidadpatrimonialkmm.data.remote.dto

import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent
import kotlinx.serialization.Serializable

@Serializable
data class TrinidadResponseDto(
    val placeTypes: List<PlaceType>,
    val places: List<Place>,
    val routes: List<Route>,
    val texts: List<TextContent>
)