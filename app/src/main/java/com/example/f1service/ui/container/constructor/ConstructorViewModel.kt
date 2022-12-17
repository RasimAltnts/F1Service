package com.example.f1service.ui.container.constructor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.constant.F1Team
import com.example.f1service.mapper.ConstructorMapper
import com.example.f1service.model.DF1ConstructorModel
import com.example.f1service.model.F1ConstructorModel
import com.example.f1service.service.ApiService
import com.example.f1service.service.IRequestCallback
import com.example.f1service.service.RestService
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ConstructorViewModel @Inject constructor(
    var service: RestService,
    var apiService: ApiService,
    var mapper: ConstructorMapper,
    var f1Team: F1Team,
):ViewModel() {

    val results: MutableLiveData<DF1ConstructorModel> by lazy {
        MutableLiveData<DF1ConstructorModel> ()
    }

    private var callback = object : IRequestCallback{
        override fun isSuccesfull(response: JsonObject?) {
            response?.let {
                results.value = mapper.decodeResponse(response)
            }
        }

    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                callback,
                apiService.getConstructorResults()
            )
        }
    }

    fun f1Team(): F1Team {
        return f1Team
    }
}