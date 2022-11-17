package com.example.f1service.service

import androidx.annotation.NonNull
import com.google.gson.JsonObject
import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class RestService {

    fun sendRequest(@NonNull callback: IRequestCallback,request:Call<JsonObject>):Boolean {
        request.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    response.body().let {
                        callback.isSuccesfull(it)
                    }
                }
                else {
                    callback.isFailed(response.code())
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                callback.isError()
            }
        })
        return true
    }
}