package com.example.f1service.model.F1Driver


import com.google.gson.annotations.SerializedName

data class F1DriverStanding(
    @SerializedName("MRData")
    val mRData: MRData
)