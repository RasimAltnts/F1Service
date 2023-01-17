package com.example.f1service.di

import com.example.f1service.service.ApiService
import com.example.f1service.service.RestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteRepository {

    @Singleton
    @Provides
    fun provideRestService(): RestService {
        return RestService()
    }

    @Provides
    @Singleton
    fun providerRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl("http://ergast.com/api/f1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
