package com.example.f1service.model.F1CurrentSessionModel


import com.google.gson.annotations.SerializedName

data class Sprint(
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String
)