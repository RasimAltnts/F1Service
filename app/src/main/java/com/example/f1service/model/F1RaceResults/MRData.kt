package com.example.f1service.model.F1RaceResults

data class MRData(
    val RaceTable: RaceTable,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)