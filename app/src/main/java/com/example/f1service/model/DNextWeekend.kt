package com.example.f1service.model.model

import com.example.f1service.counter.DCounter
import java.util.*

data class DNextWeekend(
    var circuit: String? = null,
    var country: String? = null,
    var raceTime: Date? = null,
    var qualitime: Date? = null,
    var sprintTime: Date? = null,
    var counter: DCounter ? = null,
    var round: String? = "2022",
    var session: String? = "11"
)
