package com.example.f1service.di

import com.example.f1service.mapper.*
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

    @Provides
    @Singleton
    fun raceListMapper(): RaceListMapper {
        return RaceListMapper()
    }

    @Provides
    @Singleton
    fun constructorMapper(): ConstructorMapper {
        return ConstructorMapper()
    }

    @Provides
    @Singleton
    fun driverMapper(): DriverMapper {
        return DriverMapper()
    }
}