package com.inmersoft.trinidadpatrimonialkmm.data.remote

import com.inmersoft.trinidadpatrimonialkmm.data.remote.dto.TrinidadResponseDto

class TrinidadRemoteDataSource(private val api: TrinidadApi) {

    suspend fun getTrinidadData(userLocale: String = "en"): TrinidadResponseDto {
        return api.getTrinidadData(userLocale = userLocale)
    }

}