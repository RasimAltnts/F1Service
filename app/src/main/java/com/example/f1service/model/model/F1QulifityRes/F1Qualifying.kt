package com.example.f1service.model.F1QulifityRes


import com.google.gson.annotations.SerializedName

data class F1Qualifying(
    @SerializedName("MRData")
    val mRData: MRData
)