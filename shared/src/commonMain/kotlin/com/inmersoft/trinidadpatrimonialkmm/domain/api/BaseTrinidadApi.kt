package com.inmersoft.trinidadpatrimonialkmm.domain.api

import com.inmersoft.trinidadpatrimonialkmm.data.remote.dto.TrinidadResponseDto
import com.inmersoft.trinidadpatrimonialkmm.domain.models.account.AccountDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.ResultPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics.EventAnalyticsPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.review.ReviewPost


abstract class BaseTrinidadApi() {

    @Throws(Exception::class)
    abstract suspend fun getTrinidadData(userLocale: String = "en"): TrinidadResponseDto

    @Throws(Exception::class)
    abstract suspend fun fetchAllByCollection(lang: String = "en", collection: String): ContentDTO

    @Throws(Exception::class)
    abstract suspend fun postUserReview(reviewPost: ReviewPost): ResultPost

    @Throws(Exception::class)
    abstract suspend fun postUserData(userAccountData: AccountDTO): ResultPost

    @Throws(Exception::class)
    abstract suspend fun postEventAnalytics(userEventAnalytics: EventAnalyticsPost): ResultPost
}