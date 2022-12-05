package com.example.f1service.ui.container.lastRaceResults

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.mapper.LastRaceMapper
import com.example.f1service.model.DF1LastRaceModel
import com.example.f1service.service.ApiService
import com.example.f1service.service.IRequestCallback
import com.example.f1service.service.RestService
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastRaceViewModel @Inject constructor(
    var service:RestService,
    var mapper:LastRaceMapper,
    var apiService: ApiService
) : ViewModel() {

    val resultList: MutableLiveData<DF1LastRaceModel> by lazy {
        MutableLiveData<DF1LastRaceModel> ()
    }

    private val response = object : IRequestCallback {
        override fun isSuccesfull(response: JsonObject?) {
            response?.let {
                resultList.value = mapper.encodeLastRaceResponse(it)
            }
        }
    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                response,
                apiService.getLastRaceResults()
            )
        }
    }
}