package com.example.f1service.model

import com.example.f1service.model.F1CurrentSessionModel.*

data class DF1CurrentSession(
    val circuitName: String,
    val circuitId: String,
    val session: ArrayList<F1CurrentSession>,
)

data class F1CurrentSession(
    var id: Int ? = null,
    var racename: String,
    var date: String,
    var time: String,
    var round: String,
    var session: String,
    var location: Location,
    var country: String,
    var firstPractice: FirstPractice ? = null,
    var thirdPractice: ThirdPractice ? = null,
    var secondPractice: SecondPractice ? = null,
    var qualifying: Qualifying ? = null,
    var sprint: Sprint ? = null,
    var expanded: Boolean = false,
    var isPassed: Boolean = false,
)
