package com.example.f1service.model.F1NextRace


import com.google.gson.annotations.SerializedName

data class Qualifying(
    @SerializedName("date")
    var date: String,
    @SerializedName("time")
    var time: String
)