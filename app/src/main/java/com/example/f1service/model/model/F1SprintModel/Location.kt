package com.example.f1service.model.F1SprintModel


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("country")
    var country: String,
    @SerializedName("lat")
    var lat: String,
    @SerializedName("locality")
    var locality: String,
    @SerializedName("long")
    var long: String
)