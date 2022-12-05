package com.example.f1service.model

data class DF1Qualifying(
    var circuitName:String,
    val circuitId:String,
    val driverInfo:ArrayList<DQualityDriver>
)

data class DQualityDriver(
    var position:String,
    var driverName:String,
    var driverSurname:String,
    var q1Time:String?,
    var q2Time:String?,
    var q3Time:String?,
    var consId:String,
)


