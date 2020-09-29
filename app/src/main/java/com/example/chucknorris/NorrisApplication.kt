package com.example.chucknorris

import android.app.Application
import com.example.chucknorris.di.component.ChuckComponent
import com.example.chucknorris.di.component.DaggerChuckComponent
import com.example.chucknorris.di.module.ApplicationModule
import com.example.chucknorris.di.module.NetworkModule
import com.example.chucknorris.di.module.RepositoryNorrisModule
import com.example.chucknorris.di.module.VMProviderModule

class NorrisApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        chuckComponent = DaggerChuckComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .networkModule(NetworkModule())
            .repositoryNorrisModule(RepositoryNorrisModule())
            .vMProviderModule(VMProviderModule())
            .build()

    }
    companion object{
        private lateinit var chuckComponent: ChuckComponent

        fun getComponent(): ChuckComponent = chuckComponent
    }
}