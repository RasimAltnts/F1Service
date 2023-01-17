package com.example.f1service.di

import com.example.f1service.constant.*
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
        return F1Driver(
            FirebaseService.firebaseService()
        )
    }

    @Provides
    @Singleton
    fun team(): F1Team {
        return F1Team(
            FirebaseService.firebaseService()
        )
    }

    @Provides
    @Singleton
    fun country(): F1CircuitCountry {
        return F1CircuitCountry()
    }
}
