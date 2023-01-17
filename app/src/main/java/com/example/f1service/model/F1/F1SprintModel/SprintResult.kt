package com.example.f1service.model.F1SprintModel

import com.google.gson.annotations.SerializedName

data class SprintResult(
    @SerializedName("Constructor")
    var `constructor`: Constructor,
    @SerializedName("Driver")
    var driver: Driver,
    @SerializedName("FastestLap")
    var fastestLap: FastestLap,
    @SerializedName("grid")
    var grid: String,
    @SerializedName("laps")
    var laps: String,
    @SerializedName("number")
    var number: String,
    @SerializedName("points")
    var points: String,
    @SerializedName("position")
    var position: String,
    @SerializedName("positionText")
    var positionText: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("Time")
    var time: TimeX
)
