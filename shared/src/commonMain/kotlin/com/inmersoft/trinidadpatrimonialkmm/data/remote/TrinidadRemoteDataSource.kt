package com.inmersoft.trinidadpatrimonialkmm.data.remote

import com.inmersoft.trinidadpatrimonialkmm.data.remote.dto.TrinidadResponseDto
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.ContentDTO

class TrinidadRemoteDataSource(private val api: TrinidadApi) {

    suspend fun getTrinidadData(userLocale: String = "en"): TrinidadResponseDto {
        return api.getTrinidadData(userLocale = userLocale)
    }

    suspend fun fetchAllByCollection(lang: String = "en", collection: String): ContentDTO {
        return api.fetchAllByCollection(lang = lang, collection = collection)
    }
}