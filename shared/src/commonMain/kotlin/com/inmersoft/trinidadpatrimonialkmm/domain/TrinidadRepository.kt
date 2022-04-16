package com.inmersoft.trinidadpatrimonialkmm.domain

import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent

interface TrinidadRepository {

    suspend fun fetchAndCacheData(userLocale: String = "en")

    suspend fun getPlaceTypesFromDb(): List<PlaceType>
    suspend fun getPlacesFromDb(): List<Place>
    suspend fun getRoutesFromDb(): List<Route>
    suspend fun getTextsFromDb(): List<TextContent>

}