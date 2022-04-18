package com.inmersoft.trinidadpatrimonialkmm.domain

import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route
import com.inmersoft.trinidadpatrimonialkmm.domain.models.account.AccountDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.ResultPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics.EventAnalyticsPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.review.ReviewPost

interface TrinidadRepository {

    @Throws(Exception::class)
    suspend fun fetchAndCacheData(userLocale: String = "en")

    @Throws(Exception::class)
    suspend fun fetchByCollection(lang: String = "en", collection: String): ContentDTO

    @Throws(Exception::class)
    suspend fun postUserReview(postReviewPost: ReviewPost): ResultPost

    @Throws(Exception::class)
    suspend fun postUserData(userAccountData: AccountDTO): ResultPost

    @Throws(Exception::class)
    suspend fun postEventAnalytics(userEventAnalytics: EventAnalyticsPost): ResultPost

    @Throws(Exception::class)
    suspend fun getPlaceTypesFromDb(): List<PlaceType>

    @Throws(Exception::class)
    suspend fun getPlacesFromDb(): List<Place>

    @Throws(Exception::class)
    suspend fun getRoutesFromDb(): List<Route>

    @Throws(Exception::class)
    suspend fun getTextsFromDb(): List<TextContent>

}