package com.example.f1service.model.F1Driver


import com.google.gson.annotations.SerializedName

data class Constructor(
    @SerializedName("constructorId")
    val constructorId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("url")
    val url: String
)