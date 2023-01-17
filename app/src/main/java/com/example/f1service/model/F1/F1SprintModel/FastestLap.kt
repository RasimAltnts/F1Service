package com.example.f1service.model.F1SprintModel

import com.google.gson.annotations.SerializedName

data class FastestLap(
    @SerializedName("lap")
    var lap: String,
    @SerializedName("Time")
    var time: Time
)
