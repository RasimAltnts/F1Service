package com.example.f1service.service

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

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

}