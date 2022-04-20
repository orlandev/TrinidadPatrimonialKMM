package com.inmersoft.trinidadpatrimonialkmm.android

import android.app.Application


class TrinidadApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TrinidadApplication)
        }

    }
}