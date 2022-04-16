package com.inmersoft.trinidadpatrimonialkmm

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

interface DispatcherProvider {
    val io: CoroutineContext
    val ui: CoroutineContext
}

class DispatcherProviderImpl : DispatcherProvider {
    override val io: CoroutineContext = Dispatchers.Default
    override val ui: CoroutineContext = Dispatchers.Main
}