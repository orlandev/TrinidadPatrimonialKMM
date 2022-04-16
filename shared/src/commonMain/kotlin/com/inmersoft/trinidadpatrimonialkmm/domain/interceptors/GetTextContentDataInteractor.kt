package com.inmersoft.trinidadpatrimonialkmm.domain.interceptors

import com.inmersoft.trinidadpatrimonialkmm.domain.TrinidadRepository
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent


interface GetTextContentDataInteractor {
    suspend fun execute(): List<TextContent>
}

class GetTextContentDataInteractorImpl(private val repo: TrinidadRepository) :
    GetTextContentDataInteractor {
    override suspend fun execute(): List<TextContent> {
        return repo.getTextsFromDb()
    }
}