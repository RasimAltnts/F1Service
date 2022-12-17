package com.example.f1service.model

data class DF1DriversModels(
    var session: String? = null,
    var round: String ?= null,
    var list: ArrayList<F1DriverModels> ?= null
)

data class F1DriverModels(
    var pilotName:String,
    var pilotSurname:String,
    var constructorId:String,
    var points:String,
    var position:String
)
