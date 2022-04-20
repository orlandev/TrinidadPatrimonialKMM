package com.inmersoft.trinidadpatrimonialkmm.coroutine

import kotlinx.coroutines.Dispatchers

internal actual fun getDispatcherProvider(): DispatcherProvider = AndroidDispatcherProvider()

internal class AndroidDispatcherProvider :
    DispatcherProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
    override val unconfined = Dispatchers.Unconfined
}