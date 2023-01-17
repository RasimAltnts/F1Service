package com.example.f1service.service

import com.google.gson.JsonObject

interface IRequestCallback {
    fun isSuccesfull(response: JsonObject?)

    fun isFailed(ErrorCode: Int) {
        println("ErrorCode:$ErrorCode")
    }
    fun isError() {
        println("Request is Error")
    }
}
