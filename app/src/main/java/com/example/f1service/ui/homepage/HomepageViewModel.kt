package com.example.f1service.ui.homepage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.mapper.NextRaceMapper
import com.example.f1service.model.model.DNextRaceModel
import com.example.f1service.service.ApiService
import com.example.f1service.service.IRequestCallback
import com.example.f1service.service.RestService
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    val nextRaceMapper: NextRaceMapper,
    val service: RestService,
    val apiService: ApiService,
) : ViewModel() {

    private var mDNextRaceModel:DNextRaceModel ?= null

    val nextRaceInfo:MutableLiveData<DNextRaceModel> by lazy {
        MutableLiveData<DNextRaceModel> ()
    }

    private val response = object : IRequestCallback {
        override fun isSuccesfull(response: JsonObject?) {
            response?.let {
                mDNextRaceModel =
                    nextRaceMapper.decodeNextRaceResponse(it)
                nextRaceInfo.value = mDNextRaceModel
            }
        }
    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                response,
                apiService.getNextRace()
            )
        }
    }
}