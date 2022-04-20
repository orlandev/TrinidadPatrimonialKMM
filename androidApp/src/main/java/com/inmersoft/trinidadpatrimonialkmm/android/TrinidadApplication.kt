package com.inmersoft.trinidadpatrimonialkmm.android

import android.app.Application
import com.inmersoft.trinidadpatrimonialkmm.di.initKoin

class TrinidadApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}