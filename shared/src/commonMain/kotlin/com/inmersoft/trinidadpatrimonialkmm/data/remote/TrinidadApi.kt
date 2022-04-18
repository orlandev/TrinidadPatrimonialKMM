package com.inmersoft.trinidadpatrimonialkmm.data.remote

import com.inmersoft.trinidadpatrimonialkmm.data.remote.dto.TrinidadResponseDto
import com.inmersoft.trinidadpatrimonialkmm.domain.models.account.AccountDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentDTO
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.ResultPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.posts.analytics.EventAnalyticsPost
import com.inmersoft.trinidadpatrimonialkmm.domain.models.review.ReviewPost
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class TrinidadApi {

    private val httpClient = HttpClient() {

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HTTP Client", message = message)
                }
            }
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(DefaultRequest) {
            headers.append("Content-Type", "application/json")
            headers.append("Authorization", "Basic $trinidadApiKey")
        }

    }

    @Throws(Exception::class)
    suspend fun getTrinidadData(userLocale: String = "en"): TrinidadResponseDto {
        return httpClient.get("$TRINIDAD_API_ENDPOINT/api/load/all?lang=$userLocale")
    }

    @Throws(Exception::class)
    suspend fun fetchAllByCollection(
        lang: String = "en",
        collection: String
    ): ContentDTO {
        return httpClient.get("$TRINIDAD_API_ENDPOINT/api/load/all?lang=$lang&collection=$collection")
    }

    @Throws(Exception::class)
    suspend fun postUserReview(reviewPost: ReviewPost): ResultPost {
        val response: ResultPost = httpClient.post("$TRINIDAD_API_ENDPOINT/api/save/stars") {
            contentType(ContentType.Application.Json)
            body = reviewPost
        }
        return response
    }

    @Throws(Exception::class)
    suspend fun postUserData(userAccountData: AccountDTO): ResultPost {
        val response: ResultPost = httpClient.post("$TRINIDAD_API_ENDPOINT/api/gmail/save") {
            contentType(ContentType.Application.Json)
            body = userAccountData
        }
        return response
    }

    @Throws(Exception::class)
    suspend fun postEventAnalytics(userEventAnalytics: EventAnalyticsPost): ResultPost {
        val response: ResultPost = httpClient.post("$TRINIDAD_API_ENDPOINT/api/analytics") {
            contentType(ContentType.Application.Json)
            body = userEventAnalytics
        }
        return response
    }

    companion object {
        private const val TRINIDAD_API_ENDPOINT = "https://trinidad-dashboard-server.herokuapp.com"
        private const val trinidadApiKey = "YXBwOjhhNzRiODA3YTA5NjlkYTBkM2Q3NGNjYzNhZQ"
    }

}