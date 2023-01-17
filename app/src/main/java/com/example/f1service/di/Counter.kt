package com.example.f1service.di

import com.example.f1service.counter.NextRaceCounter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Counter {

    @Provides
    @Singleton
    fun counter(): NextRaceCounter {
        return NextRaceCounter()
    }
}
