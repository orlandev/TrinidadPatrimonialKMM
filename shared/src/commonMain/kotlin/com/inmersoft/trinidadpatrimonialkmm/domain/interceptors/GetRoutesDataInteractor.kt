package com.inmersoft.trinidadpatrimonialkmm.domain.interceptors

import com.inmersoft.trinidadpatrimonialkmm.domain.TrinidadRepository
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route


interface GetRoutesDataInteractor {
    suspend fun execute(): List<Route>
}

class GetRoutesInteractorImpl(private val repo: TrinidadRepository) : GetRoutesDataInteractor {
    override suspend fun execute(): List<Route> {
        return repo.getRoutesFromDb()
    }
}