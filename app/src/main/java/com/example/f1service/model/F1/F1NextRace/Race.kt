package com.example.f1service.model.F1NextRace

import com.google.gson.annotations.SerializedName

data class Race(
    @SerializedName("Circuit")
    var circuit: Circuit,
    @SerializedName("date")
    var date: String,
    @SerializedName("FirstPractice")
    var firstPractice: FirstPractice,
    @SerializedName("Qualifying")
    var qualifying: Qualifying,
    @SerializedName("raceName")
    var raceName: String,
    @SerializedName("round")
    var round: String,
    @SerializedName("season")
    var season: String,
    @SerializedName("SecondPractice")
    var secondPractice: SecondPractice,
    @SerializedName("Sprint")
    var sprint: Sprint? = null,
    @SerializedName("time")
    var time: String,
    @SerializedName("url")
    var url: String
)
