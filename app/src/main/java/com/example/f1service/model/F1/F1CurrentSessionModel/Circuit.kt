package com.example.f1service.model.F1CurrentSessionModel

import com.google.gson.annotations.SerializedName

data class Circuit(
    @SerializedName("circuitId")
    val circuitId: String,
    @SerializedName("circuitName")
    val circuitName: String,
    @SerializedName("Location")
    val location: Location,
    @SerializedName("url")
    val url: String
)
