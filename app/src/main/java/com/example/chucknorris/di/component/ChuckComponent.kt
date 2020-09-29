package com.example.chucknorris.di.component

import com.example.chucknorris.MainActivity
import com.example.chucknorris.di.module.ApplicationModule
import com.example.chucknorris.di.module.NetworkModule
import com.example.chucknorris.di.module.RepositoryNorrisModule
import com.example.chucknorris.di.module.VMProviderModule
import com.example.chucknorris.view.NamedFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class,
    RepositoryNorrisModule::class, VMProviderModule::class, ApplicationModule::class])
@Singleton//need if you have singleton if a provider is a singleton
interface ChuckComponent {
    fun inject(mainActivity: MainActivity)
    fun fragmentInject(namedFragment: NamedFragment)

}