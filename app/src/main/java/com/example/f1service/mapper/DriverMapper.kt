package com.example.f1service.mapper

import com.example.f1service.model.DF1DriversModels
import com.example.f1service.model.F1Driver.DriverStanding
import com.example.f1service.model.F1Driver.F1DriverStanding
import com.example.f1service.model.F1DriverModels
import com.google.gson.Gson
import com.google.gson.JsonObject

class DriverMapper {
    private var gson = Gson()

    fun decodeResponse(jsonObject: JsonObject):DF1DriversModels {
        val response = gson.fromJson(jsonObject, F1DriverStanding::class.java)
        val res = DF1DriversModels(
            response.mRData.standingsTable.standingsLists[0].season,
            response.mRData.standingsTable.standingsLists[0].round,
            encodeRes(response.mRData.standingsTable.standingsLists[0].driverStandings)
        )

        return res
    }

    private fun encodeRes(list: List<DriverStanding>):ArrayList<F1DriverModels> {
        val result: ArrayList<F1DriverModels> = ArrayList()
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val value = iterator.next()
            val res = F1DriverModels(
                pilotName = value.driver.givenName,
                pilotSurname = value.driver.familyName,
                constructorId = value.constructors[0].constructorId,
                points = value.points,
                position = value.position
            )

            result.add(res)
        }

        return result
    }
}