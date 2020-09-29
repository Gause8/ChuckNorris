package com.example.chucknorris.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val context: Context){
    @Provides
    fun provideNorrisContext():Context = context
}