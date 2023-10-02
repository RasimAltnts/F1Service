package com.example.f1service.service

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestService {

    inline fun sendRequest(
        request:Call<JsonObject>,
        crossinline onSuccessListener: (JsonObject) -> Unit,
        crossinline onFailedListener: (errorCode: Int?, message: String) -> Unit
   ):Boolean {
        request.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccessListener(it)
                    }
                }
                else onFailedListener(response.code(),"Request is Failed")

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                onFailedListener(null,"Request is Failed")
            }
        })
        return true
    }
}