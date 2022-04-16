package com.inmersoft.trinidadpatrimonialkmm.domain.interceptors

import com.inmersoft.trinidadpatrimonialkmm.domain.TrinidadRepository
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place


interface GetPlaceDataInteractor {
    suspend fun execute(): List<Place>
}

class GetPlaceInteractorImpl(private val repo: TrinidadRepository) : GetPlaceDataInteractor {
    override suspend fun execute(): List<Place> {
        return repo.getPlacesFromDb()
    }
}