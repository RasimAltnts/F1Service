package com.example.f1service.mapper

import com.example.f1service.extension.compareDate
import com.example.f1service.extension.time
import com.example.f1service.model.DF1CurrentSession
import com.example.f1service.model.F1CurrentSession
import com.example.f1service.model.F1CurrentSessionModel.DF1CurrentSessionModels
import com.example.f1service.model.F1CurrentSessionModel.Race
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.time.ZonedDateTime

class RaceListMapper() {
    private var gson = Gson()

    fun decodeResponse(jsonObject: JsonObject): DF1CurrentSession {
        val currentSessionModels = gson.fromJson(jsonObject, DF1CurrentSessionModels::class.java)
        val result = DF1CurrentSession(
            circuitName = currentSessionModels.mRData.raceTable.races[0].circuit.circuitName,
            circuitId = currentSessionModels.mRData.raceTable.races[0].circuit.circuitId,
            session = sessionList(currentSessionModels.mRData.raceTable.races),
        )
        return result
    }

    private fun sessionList(list: List<Race>): ArrayList<F1CurrentSession> {
        val result: ArrayList<F1CurrentSession> = ArrayList()
        var i = 0
        while (i < list.size) {
            val res = F1CurrentSession(
                id = i,
                date = list[i].date,
                time = list[i].time,
                session = list[i].season,
                round = list[i].round,
                racename = list[i].raceName,
                location = list[i].circuit.location,
                country = list[i].circuit.location.country,
                firstPractice = list[i].firstPractice,
                secondPractice = list[i].secondPractice,
                thirdPractice = list[i].thirdPractice,
                qualifying = list[i].qualifying,
                sprint = list[i].sprint,
                expanded = false,
                isPassed = ZonedDateTime.now().compareDate(
                    ZonedDateTime.now().time(date = list[i].date, time = list[i].time)
                )
            )
            result.add(res)
            i++
        }

        return result
    }
}
