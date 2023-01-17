package com.example.f1service.model.F1CurrentSessionModel

import com.google.gson.annotations.SerializedName

data class Race(
    @SerializedName("Circuit")
    val circuit: Circuit,
    @SerializedName("date")
    val date: String,
    @SerializedName("FirstPractice")
    val firstPractice: FirstPractice,
    @SerializedName("Qualifying")
    val qualifying: Qualifying,
    @SerializedName("raceName")
    val raceName: String,
    @SerializedName("round")
    val round: String,
    @SerializedName("season")
    val season: String,
    @SerializedName("SecondPractice")
    val secondPractice: SecondPractice,
    @SerializedName("Sprint")
    val sprint: Sprint,
    @SerializedName("ThirdPractice")
    val thirdPractice: ThirdPractice,
    @SerializedName("time")
    val time: String,
    @SerializedName("url")
    val url: String
)
