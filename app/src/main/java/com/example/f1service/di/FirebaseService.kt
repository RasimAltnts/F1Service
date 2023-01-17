package com.example.f1service.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseService {

    @Singleton
    @Provides
    fun firebaseService(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}
