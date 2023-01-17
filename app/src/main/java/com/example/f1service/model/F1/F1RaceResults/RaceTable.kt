package com.example.f1service.model.F1RaceResults

data class RaceTable(
    val Races: List<Race>,
    val round: String,
    val season: String
)
