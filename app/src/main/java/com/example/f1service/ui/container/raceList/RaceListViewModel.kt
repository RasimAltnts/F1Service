package com.example.f1service.ui.container.raceList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.constant.F1CircuitCountry
import com.example.f1service.mapper.RaceListMapper
import com.example.f1service.model.DF1CurrentSession
import com.example.f1service.service.ApiService
import com.example.f1service.service.RestService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RaceListViewModel @Inject constructor(
    var service: RestService,
    var apiService: ApiService,
    var f1Circ: F1CircuitCountry,
    var raceListMapper: RaceListMapper,
) : ViewModel() {

    val calendar:MutableLiveData<DF1CurrentSession> by lazy {
        MutableLiveData<DF1CurrentSession> ()
    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                apiService.getRaceCalendar(), {
                    calendar.value = raceListMapper.decodeResponse(jsonObject = it)
                }, { errorCode, message ->
                    Log.d("I/Error",
                        "Constructor Request Error. Error Code is $errorCode. Message is $message")
                }
            )
        }
    }
}