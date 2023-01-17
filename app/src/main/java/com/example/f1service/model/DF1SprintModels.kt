package com.example.f1service.model

data class DF1SprintModels(
    val circiutName: String,
    val circiutId: String,
    val sprintDriver: ArrayList<DF1SprintDriverModels>
)

data class DF1SprintDriverModels(
    val number: String,
    val position: String,
    val points: String,
    val driverId: String,
    val name: String,
    val familyName: String,
    val team: String,
)
