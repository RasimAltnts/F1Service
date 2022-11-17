package com.example.f1service.model.model.F1LastRace

data class FastestLap(
    val AverageSpeed: AverageSpeed,
    val Time: Time,
    val lap: String,
    val rank: String = ""
)