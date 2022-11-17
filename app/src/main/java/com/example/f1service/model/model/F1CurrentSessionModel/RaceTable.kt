package com.example.f1service.model.F1CurrentSessionModel


import com.google.gson.annotations.SerializedName

data class RaceTable(
    @SerializedName("Races")
    val races: List<Race>,
    @SerializedName("season")
    val season: String
)