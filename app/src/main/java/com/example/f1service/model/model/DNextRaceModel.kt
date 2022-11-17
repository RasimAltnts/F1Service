package com.example.f1service.model.model

import com.example.f1service.counter.DCounter
import com.example.f1service.model.F1NextRace.FirstPractice
import com.example.f1service.model.F1NextRace.Qualifying
import com.example.f1service.model.F1NextRace.SecondPractice

data class DNextRaceModel(
    var nextRaceName:String,
    var nextRaceCircuitName:String,
    var nextRaceDate:String,
    var nextRaceTime:String,
    var nextRaceCountry:String,
    var nextRaceCity:String,
    var nextRaceFirstPractice: FirstPractice,
    var nextRaceSecondPractice: SecondPractice,
    var qualifying: Qualifying,
    var nextRaceRound:String,
    var nextRaceYear:String,
    var sprintTime:String?,
    var sprintDate:String?,
    var counter: DCounter = DCounter("0","0","0","0")
)
