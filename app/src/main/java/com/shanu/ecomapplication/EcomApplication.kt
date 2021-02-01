package com.shanu.ecomapplication

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.shanu.ecomapplication.retrofit.MainFragRepository
import com.shanu.ecomapplication.retrofit.api.ApiInterface
import com.shanu.ecomapplication.retrofit.base.RetrofitNetwork
import com.shanu.ecomapplication.retrofit.interceptor.NetworkConnectionInterceptor
import com.shanu.ecomapplication.viewModel.MainFragViewModel
import com.shanu.ecomapplication.viewModel.common.ViewModelFactory
import com.shanu.ecomapplication.viewModel.common.bindViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class EcomApplication : Application(), KodeinAware {

    companion object {
        lateinit var instance: EcomApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@EcomApplication))

        // Common Components
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind<ApiInterface>() with singleton { RetrofitNetwork.getApiInterface(instance()) }
        bind<ViewModelProvider.Factory>() with singleton {
            ViewModelFactory(
                kodein.direct
            )
        }

        // For MainFragment ViewModel & Repository
        bindViewModel<MainFragViewModel>() with provider {
            MainFragViewModel(
                instance(),
                instance()
            )
        }
        bind() from singleton { MainFragRepository(instance()) }
    }

}