package com.example.f1service.model.F1QulifityRes


import com.google.gson.annotations.SerializedName

data class Driver(
    @SerializedName("code")
    val code: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("driverId")
    val driverId: String,
    @SerializedName("familyName")
    val familyName: String,
    @SerializedName("givenName")
    val givenName: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("permanentNumber")
    val permanentNumber: String,
    @SerializedName("url")
    val url: String
)