package com.example.f1service.model.driverModel


import com.google.gson.annotations.SerializedName

data class Driver(
    @SerializedName("code")
    var code: String,
    @SerializedName("dateOfBirth")
    var dateOfBirth: String,
    @SerializedName("driverId")
    var driverId: String,
    @SerializedName("familyName")
    var familyName: String,
    @SerializedName("givenName")
    var givenName: String,
    @SerializedName("nationality")
    var nationality: String,
    @SerializedName("permanentNumber")
    var permanentNumber: String,
    @SerializedName("url")
    var url: String
)