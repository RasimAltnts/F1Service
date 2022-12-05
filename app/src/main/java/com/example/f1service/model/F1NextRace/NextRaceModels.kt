package com.example.f1service.model.F1NextRace


import com.google.gson.annotations.SerializedName

data class NextRaceModels(
    @SerializedName("MRData")
    var mRData: MRData
)