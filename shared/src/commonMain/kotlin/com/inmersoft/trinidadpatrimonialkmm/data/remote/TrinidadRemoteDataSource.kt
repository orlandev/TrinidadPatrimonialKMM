package com.inmersoft.trinidadpatrimonialkmm.data.remote

import com.inmersoft.trinidadpatrimonialkmm.data.remote.dto.TrinidadResponseDto
import com.inmersoft.trinidadpatrimonialkmm.domain.models.account.AccountDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.ResultPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics.EventAnalyticsPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.review.ReviewPost

class TrinidadRemoteDataSource(private val api: TrinidadApi) {

    @Throws(Exception::class)
    suspend fun getTrinidadData(userLocale: String = "en"): TrinidadResponseDto {
        return api.getTrinidadData(userLocale = userLocale)
    }

    @Throws(Exception::class)
    suspend fun fetchAllByCollection(lang: String = "en", collection: String): ContentDTO {
        return api.fetchAllByCollection(lang = lang, collection = collection)
    }

    @Throws(Exception::class)
    suspend fun postUserReview(reviewPost: ReviewPost): ResultPost {
        return api.postUserReview(reviewPost)
    }

    @Throws(Exception::class)
    suspend fun postUserData(userAccountData: AccountDTO): ResultPost {
        return api.postUserData(userAccountData)
    }

    @Throws(Exception::class)
    suspend fun postEventAnalytics(userEventAnalytics: EventAnalyticsPost): ResultPost {
        return api.postEventAnalytics(userEventAnalytics)
    }

}