package com.example.f1service.model.F1SprintModel


import com.google.gson.annotations.SerializedName

data class TimeX(
    @SerializedName("millis")
    var millis: String,
    @SerializedName("time")
    var time: String
)