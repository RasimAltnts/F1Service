package com.example.f1service.model.F1SprintModel


import com.google.gson.annotations.SerializedName

data class Constructor(
    @SerializedName("constructorId")
    var constructorId: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("nationality")
    var nationality: String,
    @SerializedName("url")
    var url: String
)