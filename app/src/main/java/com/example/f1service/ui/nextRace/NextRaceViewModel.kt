package com.example.f1service.ui.nextRace

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.mapper.NextRaceMapper
import com.example.f1service.model.model.DNextRaceModel
import com.example.f1service.model.model.F1LastRace.LastRaceResults
import com.example.f1service.service.ApiService
import com.example.f1service.service.RestService
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NextRaceViewModel @Inject constructor(
    val nextRaceMapper: NextRaceMapper,
    val service: RestService,
    val apiService: ApiService,
) : ViewModel() {

    private var mDNextRaceModel:DNextRaceModel ?= null

    val nextRaceInfo:MutableLiveData<DNextRaceModel> by lazy {
        MutableLiveData<DNextRaceModel> ()
    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                apiService.getNextRace(), {

                    mDNextRaceModel =
                        nextRaceMapper.decodeNextRaceResponse(it)

                    if (mDNextRaceModel != null) {
                        nextRaceInfo.value = mDNextRaceModel
                    }

                    else {
                        sendLastRaceRequest()
                    }
                }, { errorCode, message ->
                    Log.d("I/Error",
                        "Constructor Request Error. Error Code is $errorCode. Message is $message")
                }
            )
        }
    }

    private fun sendLastRaceRequest() {
        viewModelScope.launch {
            service.sendRequest(
                apiService.getLastRaceResults(), {
                    nextRaceInfo.value = encodeLastRaceResponse(it)
                } ,
                { errorCode, message ->
                    Log.d("I/Error",
                        "Constructor Request Error. Error Code is $errorCode. Message is $message")
                }
            )
        }
    }

    private fun encodeLastRaceResponse(res:JsonObject): DNextRaceModel {
        val gson = Gson()
        val mDF1LastRaceResults = gson.fromJson(res, LastRaceResults::class.java)

        val mDNextRaceModel = DNextRaceModel()

        mDF1LastRaceResults?.let {
            mDNextRaceModel.nextRaceName = it.MRData.RaceTable.Races[0].raceName
            mDNextRaceModel.nextRaceCircuitName = it.MRData.RaceTable.Races[0].Circuit.circuitName
            mDNextRaceModel.nextRaceDate = it.MRData.RaceTable.Races[0].date
            mDNextRaceModel.nextRaceTime = it.MRData.RaceTable.Races[0].time
            mDNextRaceModel.nextRaceCountry = it.MRData.RaceTable.Races[0].Circuit.Location.country
            mDNextRaceModel.nextRaceCity = it.MRData.RaceTable.Races[0].Circuit.Location.locality
            mDNextRaceModel.nextRaceYear = it.MRData.RaceTable.season
            mDNextRaceModel.nextRaceRound = it.MRData.RaceTable.round
        }

        return mDNextRaceModel

    }
}