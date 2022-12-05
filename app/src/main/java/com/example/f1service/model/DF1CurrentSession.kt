package com.example.f1service.model

import com.example.f1service.model.F1CurrentSessionModel.Location

data class DF1CurrentSession(
    val circuitName:String,
    val circuitId:String,
    val session:ArrayList<F1CurrentSession>,
)


data class F1CurrentSession(
    var racename:String,
    var date:String,
    var time:String,
    var round:String,
    var session:String,
    var location: Location,
    var country: String,
)
