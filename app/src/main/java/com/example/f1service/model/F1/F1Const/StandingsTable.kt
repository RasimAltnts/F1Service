package com.example.f1service.model.F1Const

import com.google.gson.annotations.SerializedName

data class StandingsTable(
    @SerializedName("season")
    val season: String,
    @SerializedName("StandingsLists")
    val standingsLists: List<StandingsLists>
)
