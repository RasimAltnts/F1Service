package com.example.f1service.mapper

import com.example.f1service.model.DF1ConstructorModel
import com.example.f1service.model.F1Const.ConstructorStanding
import com.example.f1service.model.F1Const.F1Constructor
import com.example.f1service.model.F1ConstructorModel
import com.google.gson.Gson
import com.google.gson.JsonObject

class ConstructorMapper {
    private var gson = Gson()

    /**
     * This Function make encode Constructor Response
     */

    fun decodeResponse(jsonObject: JsonObject): DF1ConstructorModel {
        val response = gson.fromJson(jsonObject, F1Constructor::class.java)
        val res = DF1ConstructorModel(
            response.mRData.standingsTable.standingsLists[0].season,
            response.mRData.standingsTable.standingsLists[0].round,
            encodeConstructorList(
                response.mRData.standingsTable.standingsLists[0].constructorStandings
            )
        )
        return res
    }

    private fun encodeConstructorList(list: List<ConstructorStanding>):
        ArrayList<F1ConstructorModel> {
            val results: ArrayList<F1ConstructorModel> = ArrayList()

            val iterator = list.iterator()
            while (iterator.hasNext()) {
                val value = iterator.next()
                val res = F1ConstructorModel(
                    name = value.constructor.name,
                    consId = value.constructor.constructorId,
                    position = value.position,
                    points = value.points,
                    wins = value.wins,
                    url = value.constructor.url,
                )

                results.add(res)
            }

            return results
        }
}
