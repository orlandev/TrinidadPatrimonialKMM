package com.inmersoft.trinidadpatrimonialkmm.data.remote

import com.inmersoft.trinidadpatrimonialkmm.coroutine.DispatcherProvider
import com.inmersoft.trinidadpatrimonialkmm.data.remote.dto.TrinidadResponseDto
import com.inmersoft.trinidadpatrimonialkmm.domain.models.account.AccountDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.ResultPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics.EventAnalyticsPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.review.ReviewPost
import kotlinx.coroutines.withContext

class TrinidadRemoteDataSource(
    private val api: TrinidadApi,
    private val dispatcherProvider: DispatcherProvider
) {

    @Throws(Exception::class)
    suspend fun getTrinidadData(userLocale: String = "en"): TrinidadResponseDto {
        return withContext(dispatcherProvider.io) { api.getTrinidadData(userLocale = userLocale) }
    }

    @Throws(Exception::class)
    suspend fun fetchAllByCollection(lang: String = "en", collection: String): ContentDTO {
        return withContext(dispatcherProvider.io) {
            api.fetchAllByCollection(
                lang = lang,
                collection = collection
            )
        }
    }

    @Throws(Exception::class)
    suspend fun postUserReview(reviewPost: ReviewPost): ResultPost {
        return withContext(dispatcherProvider.io) { api.postUserReview(reviewPost) }
    }

    @Throws(Exception::class)
    suspend fun postUserData(userAccountData: AccountDTO): ResultPost {
        return withContext(dispatcherProvider.io) { api.postUserData(userAccountData) }
    }

    @Throws(Exception::class)
    suspend fun postEventAnalytics(userEventAnalytics: EventAnalyticsPost): ResultPost {
        return withContext(dispatcherProvider.io) { api.postEventAnalytics(userEventAnalytics) }
    }

}