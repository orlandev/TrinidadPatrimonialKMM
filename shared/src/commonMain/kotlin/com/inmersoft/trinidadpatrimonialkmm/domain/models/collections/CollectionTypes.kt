package com.inmersoft.trinidadpatrimonialkmm.domain.models.collections

sealed class CollectionTypes(val id: String) {
    object News : CollectionTypes("news")
    object Events : CollectionTypes("events")
    object Texts : CollectionTypes("texts")
}
