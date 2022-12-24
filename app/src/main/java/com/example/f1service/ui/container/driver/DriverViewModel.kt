package com.example.f1service.ui.container.driver

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1service.constant.F1Driver
import com.example.f1service.constant.F1Team
import com.example.f1service.di.FirebaseService
import com.example.f1service.mapper.DriverMapper
import com.example.f1service.model.DF1DriversModels
import com.example.f1service.model.F1Const.F1Constructor
import com.example.f1service.service.ApiService
import com.example.f1service.service.IRequestCallback
import com.example.f1service.service.RestService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriverViewModel @Inject constructor(
    var service: RestService,
    var apiService: ApiService,
    var driverMapper: DriverMapper,
    val f1Driver: F1Driver,
    var f1Team: F1Team,
): ViewModel() {

    val result: MutableLiveData<DF1DriversModels> by lazy {
        MutableLiveData<DF1DriversModels> ()
    }

    private val callback = object : IRequestCallback {
        override fun isSuccesfull(response: JsonObject?) {
            response?.let {
                result.value = driverMapper.decodeResponse(it)
            }
        }
    }

    fun sendRequest() {
        viewModelScope.launch {
            service.sendRequest(
                callback,
                apiService.getDriverResults()
            )
        }
    }

    fun getDriverImage():F1Driver {
        return f1Driver
    }



    fun getConsImage(): F1Team {
        return f1Team
    }
}