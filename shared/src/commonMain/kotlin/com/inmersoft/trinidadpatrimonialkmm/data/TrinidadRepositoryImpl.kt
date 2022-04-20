package com.inmersoft.trinidadpatrimonialkmm.data

import com.inmersoft.trinidadpatrimonialkmm.coroutine.DispatcherProvider
import com.inmersoft.trinidadpatrimonialkmm.data.local.TrinidadLocalDataSource
import com.inmersoft.trinidadpatrimonialkmm.data.remote.TrinidadRemoteDataSource
import com.inmersoft.trinidadpatrimonialkmm.domain.TrinidadRepository
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route
import com.inmersoft.trinidadpatrimonialkmm.domain.models.account.AccountDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.ResultPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics.EventAnalyticsPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.review.ReviewPost
import kotlinx.coroutines.withContext

class TrinidadRepositoryImpl(
    private val localDataSource: TrinidadLocalDataSource,
    private val remoteDataSource: TrinidadRemoteDataSource,
    private val dispatcherProvider: DispatcherProvider
) : TrinidadRepository {
    @Throws(Exception::class)
    override suspend fun fetchAndCacheData(userLocale: String) {
        withContext(dispatcherProvider.io) {
            val resultDto = remoteDataSource.getTrinidadData(userLocale = userLocale)
            localDataSource.insertPlaces(resultDto.places)
            localDataSource.insertRoutes(resultDto.routes)
            localDataSource.insertPlaceType(resultDto.placeTypes)
            localDataSource.insertTextContent(resultDto.texts)
        }
    }

    @Throws(Exception::class)
    override suspend fun fetchByCollection(lang: String, collection: String): ContentDTO {
        return remoteDataSource.fetchAllByCollection(lang, collection)
    }

    @Throws(Exception::class)
    override suspend fun postUserReview(postReviewPost: ReviewPost): ResultPost {
        return remoteDataSource.postUserReview(postReviewPost)
    }

    @Throws(Exception::class)
    override suspend fun postUserData(userAccountData: AccountDTO): ResultPost {
        return remoteDataSource.postUserData(userAccountData)
    }

    @Throws(Exception::class)
    override suspend fun postEventAnalytics(userEventAnalytics: EventAnalyticsPost): ResultPost {
        return remoteDataSource.postEventAnalytics(userEventAnalytics)
    }

    @Throws(Exception::class)
    override suspend fun getPlaceTypesFromDb(): List<PlaceType> {
        return localDataSource.getAllPlaceType()
    }

    @Throws(Exception::class)
    override suspend fun getPlacesFromDb(): List<Place> {
        return localDataSource.getAllPlaces()
    }

    @Throws(Exception::class)
    override suspend fun getRoutesFromDb(): List<Route> {
        return localDataSource.getAllRoutes()
    }

    @Throws(Exception::class)
    override suspend fun getTextsFromDb(): List<TextContent> {
        return localDataSource.getAllTextContent()
    }

}