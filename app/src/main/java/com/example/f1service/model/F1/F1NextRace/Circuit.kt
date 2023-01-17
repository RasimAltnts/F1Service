package com.example.f1service.model.F1NextRace

import com.google.gson.annotations.SerializedName

data class Circuit(
    @SerializedName("circuitId")
    var circuitId: String,
    @SerializedName("circuitName")
    var circuitName: String,
    @SerializedName("Location")
    var location: Location,
    @SerializedName("url")
    var url: String
)
