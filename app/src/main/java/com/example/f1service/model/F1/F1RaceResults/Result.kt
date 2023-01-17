package com.example.f1service.model.F1RaceResults

data class Result(
    val Constructor: Constructor,
    val Driver: Driver,
    val FastestLap: FastestLap,
    val Time: TimeX,
    val grid: String,
    val laps: String,
    val number: String,
    val points: String,
    val position: String,
    val positionText: String,
    val status: String
)
