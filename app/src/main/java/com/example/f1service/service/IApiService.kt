package com.example.f1service.service

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("current/next.json")
    fun getNextRace(): Call<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("current.json")
    fun getRaceCalendar(): Call<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("current/last/results.json")
    fun getLastRaceResults(): Call<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("{session}/{round}/results.json")
    fun getRaceResults(
        @Path("session")session: String,
        @Path("round")round: String
    ): Call<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("current/constructorStandings.json")
    fun getConstructorResults(): Call<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("current/driverStandings.json")
    fun getDriverResults(): Call<JsonObject>
}
