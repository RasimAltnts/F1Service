package com.example.f1service.ui.container.raceList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.mapper.LastRaceMapper
import com.example.f1service.model.DF1CurrentSession
import com.example.f1service.model.F1CurrentSession
import com.example.f1service.model.F1CurrentSessionModel.DF1CurrentSessionModels
import com.example.f1service.model.F1CurrentSessionModel.Race
import com.example.f1service.service.ApiService
import com.example.f1service.service.IRequestCallback
import com.example.f1service.service.RestService
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RaceCalendarViewModel @Inject constructor(
    var service: RestService,
    var mapper: LastRaceMapper,
    var apiService: ApiService
) : ViewModel() {

    val calendar:MutableLiveData<DF1CurrentSession> by lazy {
        MutableLiveData<DF1CurrentSession> ()
    }

    private var gson = Gson()

    fun decodeResponse(jsonObject: JsonObject){
        val currentSessionModels = gson.fromJson(jsonObject, DF1CurrentSessionModels::class.java)
        val result= DF1CurrentSession(
            circuitName = currentSessionModels.mRData.raceTable.races[0].circuit.circuitName,
            circuitId = currentSessionModels.mRData.raceTable.races[0].circuit.circuitId,
            session = sessionList(currentSessionModels.mRData.raceTable.races),
        )

        calendar.value = result
    }

    private var raceCallback = object : IRequestCallback {
        override fun isSuccesfull(response: JsonObject?) {
            response?.let {decodeResponse(jsonObject = it) }
        }
    }


    private fun sessionList(list:List<Race>):ArrayList<F1CurrentSession> {
        val result:ArrayList<F1CurrentSession> = ArrayList()
        var i = 0

        while(i < list.size){
            val res = F1CurrentSession(
                date = list[i].date,
                time = list[i].time,
                session = list[i].season,
                round = list[i].round,
                racename = list[i].raceName,
                location = list[i].circuit.location,
                country = list[i].circuit.location.country
            )
            result.add(res)
            i++
        }

        return result
    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                raceCallback,
                apiService.getRaceCalendar()
            )
        }
    }
}