package com.inmersoft.trinidadpatrimonialkmm.domain.interceptors

import com.inmersoft.trinidadpatrimonialkmm.domain.TrinidadRepository
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType


interface GetPlaceTypeDataInteractor {
    suspend fun execute(): List<PlaceType>
}

class GetPlaceTypeDataInteractorImpl(private val repo: TrinidadRepository) :
    GetPlaceTypeDataInteractor {
    override suspend fun execute(): List<PlaceType> {
        return repo.getPlaceTypesFromDb()
    }
}