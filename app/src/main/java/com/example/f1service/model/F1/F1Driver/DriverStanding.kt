package com.example.f1service.model.F1Driver

import com.google.gson.annotations.SerializedName

data class DriverStanding(
    @SerializedName("Constructors")
    val constructors: List<Constructor>,
    @SerializedName("Driver")
    val driver: Driver,
    @SerializedName("points")
    val points: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("positionText")
    val positionText: String,
    @SerializedName("wins")
    val wins: String
)
