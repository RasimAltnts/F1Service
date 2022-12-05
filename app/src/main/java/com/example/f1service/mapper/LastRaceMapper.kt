package com.example.f1service.mapper

import com.example.f1service.model.DF1LastRaceModel
import com.example.f1service.model.DLastRaceResult
import com.example.f1service.model.model.F1LastRace.LastRaceResults
import com.example.f1service.model.model.F1LastRace.Result
import com.google.gson.Gson
import com.google.gson.JsonObject


class LastRaceMapper {
    private var gson = Gson()

    fun encodeLastRaceResponse(jsonObject: JsonObject):DF1LastRaceModel {

        val result = DF1LastRaceModel()
        val mDF1LastRaceResults = gson.fromJson(jsonObject, LastRaceResults::class.java)

        result.circuitName = mDF1LastRaceResults.MRData.RaceTable.Races[0].Circuit.circuitName
        result.circuitId = mDF1LastRaceResults.MRData.RaceTable.Races[0].Circuit.circuitId
        result.pilot = encodeResults(mDF1LastRaceResults.MRData.RaceTable.Races[0].Results)

        return result
    }

    private fun encodeResults(result: List<Result>): ArrayList<DLastRaceResult> {
        val results: ArrayList<DLastRaceResult> = ArrayList()

        val iterator = result.listIterator()
        while (iterator.hasNext()) {
            val value = iterator.next()
            val res = DLastRaceResult(
                position = value.position,
                point =  value.points,
                pilotName = value.Driver.givenName,
                pilotSurname = value.Driver.familyName,
                constructorName = value.Constructor.name,
                constructorId = value.Constructor.constructorId,
                driverId = value.Driver.driverId,
                carNumber = value.Driver.permanentNumber

            )
            results.add(res)
        }
        return results
    }
}