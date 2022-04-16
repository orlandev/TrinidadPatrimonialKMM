package com.inmersoft.trinidadpatrimonialkmm.data.remote

import com.inmersoft.trinidadpatrimonialkmm.data.remote.dto.TrinidadResponseDto
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

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

        defaultRequest {
            header("Authorization", "Basic $trinidadApiKey")
        }
    }

    suspend fun getTrinidadData(userLocale: String = "en"): TrinidadResponseDto {
        return httpClient.get("$TRINIDAD_API_ENDPOINT/api/load/all?lang=$userLocale")
    }

    companion object {
        private const val TRINIDAD_API_ENDPOINT = "https://trinidad-dashboard-server.herokuapp.com"
        private const val trinidadApiKey = "YXBwOjhhNzRiODA3YTA5NjlkYTBkM2Q3NGNjYzNhZQ"
    }

}