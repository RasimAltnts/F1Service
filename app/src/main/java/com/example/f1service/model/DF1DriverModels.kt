package com.example.f1service.model


import com.example.f1service.model.driverModel.MRData
import com.google.gson.annotations.SerializedName

data class DF1DriverModels(
    @SerializedName("MRData")
    var mRData: MRData
)