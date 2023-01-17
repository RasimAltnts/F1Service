package com.example.f1service.model.F1SprintModel

import com.google.gson.annotations.SerializedName

data class MRData(
    @SerializedName("limit")
    var limit: String,
    @SerializedName("offset")
    var offset: String,
    @SerializedName("RaceTable")
    var raceTable: RaceTable,
    @SerializedName("series")
    var series: String,
    @SerializedName("total")
    var total: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("xmlns")
    var xmlns: String
)
