package com.example.f1service.model

data class DF1ConstructorModel(
    var series:String ?= null,
    var standingTable:String ?= null,
    var list:ArrayList<F1ConstructorModel> ?= null
)

data class F1ConstructorModel(
    var name:String ?= null,
    var consId:String ?= null,
    var position:String ?= null,
    var points:String ?= null,
    var wins:String ?= null,
    var url:String ?= null,
)
