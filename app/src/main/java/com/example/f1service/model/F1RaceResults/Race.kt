package com.example.f1service.model.F1RaceResults

data class Race(
    val Circuit: Circuit,
    val Results: List<Result>,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)