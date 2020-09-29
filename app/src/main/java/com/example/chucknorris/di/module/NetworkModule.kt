package com.example.chucknorris.di.module

import android.content.Context
import com.example.chucknorris.model.ChuckNorrisAPI
import com.example.chucknorris.model.Network
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module class NetworkModule {
    @Provides
    fun provideNetwork(api: ChuckNorrisAPI): Network{
        return Network(api)
    }

    @Provides
    fun provideChuckNorrisAPI(client: OkHttpClient): ChuckNorrisAPI{
        return Retrofit.Builder()
            .client(client)
            .baseUrl("http://api.icndb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckNorrisAPI::class.java)
    }
    @Provides
    fun provideOKHTTPClient(cache: Cache, loggerInterceptor: Interceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(loggerInterceptor)
            .build()
    }
    @Provides
    fun providesCache(context: Context): Cache{
        val size = 5*1024L
        val cache = Cache(context.cacheDir, size)
        return cache
    }
    @Provides
    fun provideLoggerInterceptor(): Interceptor{
        val httpLogger = HttpLoggingInterceptor()
        httpLogger.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return httpLogger
    }
}