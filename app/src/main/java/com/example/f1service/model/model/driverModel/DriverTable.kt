package com.example.f1service.model.driverModel


import com.google.gson.annotations.SerializedName

data class DriverTable(
    @SerializedName("Drivers")
    var drivers: List<Driver>
)