package com.example.f1service.mapper

import com.example.f1service.model.DRaceResults
import com.example.f1service.model.F1RaceResults.RaceResults
import com.google.gson.Gson
import com.google.gson.JsonObject

class RaceResultsMapper {
    private var gson = Gson()

    fun encodeResponse(response: JsonObject):ArrayList<DRaceResults> {
        val results: ArrayList<DRaceResults> = ArrayList()
        val raceResults = gson.fromJson(response,RaceResults::class.java)

        raceResults.MRData.RaceTable.Races[0].Results.apply {
            var i  = 0
            while (i < this.size ) {
                var encode = DRaceResults(
                    driverId = this[i].Driver.driverId,
                    driverName = this[i].Driver.givenName,
                    driverFamilyName = this[i].Driver.familyName,
                    position = this[i].position,
                    constructorName = this[i].Constructor.name,
                )
                results.add(encode)
                i++
            }
        }
        return results
    }
}