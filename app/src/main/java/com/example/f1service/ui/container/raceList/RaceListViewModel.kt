package com.example.f1service.ui.container.raceList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.constant.F1CircuitCountry
import com.example.f1service.mapper.RaceListMapper
import com.example.f1service.model.DF1CurrentSession
import com.example.f1service.service.ApiService
import com.example.f1service.service.IRequestCallback
import com.example.f1service.service.RestService
import com.google.gson.JsonObject
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

    val calendar: MutableLiveData<DF1CurrentSession> by lazy {
        MutableLiveData<DF1CurrentSession> ()
    }

    private var raceCallback = object : IRequestCallback {
        override fun isSuccesfull(response: JsonObject?) {
            response?.let {
                calendar.value = raceListMapper.decodeResponse(jsonObject = it)
            }
        }
    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                raceCallback,
                apiService.getRaceCalendar()
            )
        }
    }

    fun getF1CircuitCountry(): F1CircuitCountry {
        return f1Circ
    }
}
