package com.example.f1service.model.driverModel


import com.google.gson.annotations.SerializedName

data class MRData(
    @SerializedName("DriverTable")
    var driverTable: DriverTable,
    @SerializedName("limit")
    var limit: String,
    @SerializedName("offset")
    var offset: String,
    @SerializedName("series")
    var series: String,
    @SerializedName("total")
    var total: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("xmlns")
    var xmlns: String
)