package com.example.f1service.model.F1NextRace


import com.google.gson.annotations.SerializedName

data class RaceTable(
    @SerializedName("Races")
    var races: List<Race>,
    @SerializedName("round")
    var round: String,
    @SerializedName("season")
    var season: String
)