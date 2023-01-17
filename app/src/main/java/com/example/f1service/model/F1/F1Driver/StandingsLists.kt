package com.example.f1service.model.F1Driver

import com.google.gson.annotations.SerializedName

data class StandingsLists(
    @SerializedName("DriverStandings")
    val driverStandings: List<DriverStanding>,
    @SerializedName("round")
    val round: String,
    @SerializedName("season")
    val season: String
)
