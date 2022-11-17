package com.example.f1service.di

import com.example.f1service.mapper.LastRaceMapper
import com.example.f1service.mapper.NextRaceMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Mapper {

    @Provides
    @Singleton
    fun nextRaceMapper(): NextRaceMapper {
        return NextRaceMapper()
    }

    @Provides
    @Singleton
    fun lastRaceMapper(): LastRaceMapper {
        return LastRaceMapper()
    }
}