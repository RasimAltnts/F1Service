package com.example.f1service.model.F1CurrentSessionModel

import com.google.gson.annotations.SerializedName

data class DF1CurrentSessionModels(
    @SerializedName("MRData")
    val mRData: MRData
)
