package com.example.f1service.model.F1QulifityRes

import com.google.gson.annotations.SerializedName

data class QualifyingResult(
    @SerializedName("Constructor")
    val `constructor`: Constructor,
    @SerializedName("Driver")
    val driver: Driver,
    @SerializedName("number")
    val number: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("Q1")
    val q1: String,
    @SerializedName("Q2")
    val q2: String,
    @SerializedName("Q3")
    val q3: String
)
