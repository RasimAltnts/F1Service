package com.example.f1service.model

data class DF1LastRaceModel(
    var session:String? = null,
    var round:String ?= null,
    var circuitName: String = "",
    var circuitId: String = "",
    var pilot: ArrayList<DLastRaceResult>? = ArrayList()
)

data class DLastRaceResult(
    var position:String,
    var carNumber:String,
    var point:String,
    var pilotName:String,
    var pilotSurname:String,
    var constructorName:String,
    var constructorId:String,
    var driverId:String,
    var fastestLap:String? = null,
)