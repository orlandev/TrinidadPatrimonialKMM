package com.inmersoft.trinidadpatrimonialkmm.data

import com.inmersoft.trinidadpatrimonialkmm.data.local.TrinidadLocalDataSource
import com.inmersoft.trinidadpatrimonialkmm.data.remote.TrinidadRemoteDataSource
import com.inmersoft.trinidadpatrimonialkmm.DispatcherProvider
import com.inmersoft.trinidadpatrimonialkmm.domain.TrinidadRepository
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent
import kotlinx.coroutines.withContext

class TrinidadRepositoryImpl(
    private val localDataSource: TrinidadLocalDataSource,
    private val remoteDataSource: TrinidadRemoteDataSource,
    private val dispatcherProvider: DispatcherProvider
) : TrinidadRepository {

    override suspend fun fetchAndCacheData(userLocale: String) {
        withContext(dispatcherProvider.io) {
            val resultDto = remoteDataSource.getTrinidadData(userLocale = userLocale)
            localDataSource.insertPlaces(resultDto.places)
            localDataSource.insertRoutes(resultDto.routes)
            localDataSource.insertPlaceType(resultDto.placeTypes)
            localDataSource.insertTextContent(resultDto.texts)
        }
    }

    override suspend fun getPlaceTypesFromDb(): List<PlaceType> {
        return localDataSource.getAllPlaceType()
    }

    override suspend fun getPlacesFromDb(): List<Place> {
        return localDataSource.getAllPlaces()
    }

    override suspend fun getRoutesFromDb(): List<Route> {
        return localDataSource.getAllRoutes()
    }

    override suspend fun getTextsFromDb(): List<TextContent> {
        return emptyList()
    }

}