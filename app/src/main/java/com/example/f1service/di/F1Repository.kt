package com.example.f1service.di

import com.example.f1service.constant.F1Driver
import com.example.f1service.constant.F1Team
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object F1Repository {

    @Provides
    @Singleton
    fun driver(): F1Driver {
        return F1Driver()
    }

    @Provides
    @Singleton
    fun team(): F1Team {
        return F1Team()
    }
}