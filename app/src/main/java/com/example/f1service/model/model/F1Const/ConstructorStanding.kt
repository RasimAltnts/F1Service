package com.example.f1service.model.F1Const


import com.google.gson.annotations.SerializedName

data class ConstructorStanding(
    @SerializedName("Constructor")
    val `constructor`: Constructor,
    @SerializedName("points")
    val points: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("positionText")
    val positionText: String,
    @SerializedName("wins")
    val wins: String
)