package com.example.f1service.model.F1Const


import com.google.gson.annotations.SerializedName

data class StandingsLists(
    @SerializedName("ConstructorStandings")
    val constructorStandings: List<ConstructorStanding>,
    @SerializedName("round")
    val round: String,
    @SerializedName("season")
    val season: String
)