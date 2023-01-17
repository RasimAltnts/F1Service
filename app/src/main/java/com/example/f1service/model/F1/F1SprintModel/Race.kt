package com.example.f1service.model.F1SprintModel

import com.google.gson.annotations.SerializedName

data class Race(
    @SerializedName("Circuit")
    var circuit: Circuit,
    @SerializedName("date")
    var date: String,
    @SerializedName("raceName")
    var raceName: String,
    @SerializedName("round")
    var round: String,
    @SerializedName("season")
    var season: String,
    @SerializedName("SprintResults")
    var sprintResults: List<SprintResult>,
    @SerializedName("time")
    var time: String,
    @SerializedName("url")
    var url: String
)
