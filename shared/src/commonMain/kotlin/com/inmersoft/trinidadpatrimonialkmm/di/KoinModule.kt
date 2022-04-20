package com.inmersoft.trinidadpatrimonialkmm.di

import com.inmersoft.trinidadpatrimonialkmm.coroutine.getDispatcherProvider
import com.inmersoft.trinidadpatrimonialkmm.data.TrinidadRepositoryImpl

import com.inmersoft.trinidadpatrimonialkmm.data.local.TrinidadLocalDataSource
import com.inmersoft.trinidadpatrimonialkmm.data.remote.TrinidadRemoteDataSource
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetPlaceInteractorImpl
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetPlaceTypeDataInteractorImpl
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetRoutesInteractorImpl
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetTextContentDataInteractorImpl
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val utilityModule = module {
    factory { getDispatcherProvider() }
}

private val appModule=module{

    single {
        TrinidadRepositoryImpl(get(), get(), get())
    }
    single {
        TrinidadRemoteDataSource(get(),get())
    }
    single {
        TrinidadLocalDataSource(get())
    }
}


private val useCaseModule = module {

    single {
        GetPlaceInteractorImpl(get())
    }

    single {
        GetPlaceTypeDataInteractorImpl(get())
    }

    single {
        GetRoutesInteractorImpl(get())
    }

    single {
        GetTextContentDataInteractorImpl(get())
    }

}
private val sharedModules = listOf(appModule, useCaseModule)
fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(sharedModules)
}