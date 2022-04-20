package com.inmersoft.trinidadpatrimonialkmm.coroutine

import kotlinx.coroutines.CoroutineDispatcher

internal expect fun getDispatcherProvider(): DispatcherProvider

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
