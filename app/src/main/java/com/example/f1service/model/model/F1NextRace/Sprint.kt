package com.example.f1service.model.F1NextRace


import com.google.gson.annotations.SerializedName

data class Sprint(
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("time")
    var time: String? = null
)