package com.example.f1service.model.model

import com.example.f1service.counter.DCounter
import com.example.f1service.model.F1NextRace.FirstPractice
import com.example.f1service.model.F1NextRace.Qualifying
import com.example.f1service.model.F1NextRace.SecondPractice

data class DNextRaceModel(
    var nextRaceName: String? = null,
    var nextRaceCircuitName: String? = null,
    var nextRaceDate: String? = null,
    var nextRaceTime: String? = null,
    var nextRaceCountry: String? = null,
    var nextRaceCity: String? = null,
    var nextRaceFirstPractice: FirstPractice ? = null,
    var nextRaceSecondPractice: SecondPractice? = null,
    var qualifying: Qualifying? = null,
    var nextRaceRound: String? = null,
    var nextRaceYear: String? = null,
    var sprintTime: String? = null,
    var sprintDate: String? = null,
    var counter: DCounter = DCounter("0", "0", "0", "0")
)
