package com.example.f1service.counter

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.util.*

class NextRaceCounter {

    private val daysMilliseconds = 86400000
    private val hoursMilliseconds = 3600000
    private val minutesMilliseconds = 60000
    private val secondsMilliseconds = 1000

    private var stopTimer = false

    private var listener: INextRaceCounter ?= null

    @OptIn(DelicateCoroutinesApi::class)
    fun startTimer(date:Date){
        GlobalScope.launch(Dispatchers.Default) {
            while (true) {
                if (stopTimer) {
                    break
                }
                else {
                    getTime(date)
                }
                delay(1000L)
            }
        }
    }


    suspend fun getTime(date:Date) {
        val time: Calendar = Calendar.getInstance()
        val timeMilliseconds = time.time
        val dateMilliseconds = date.time
        val diff: Long = dateMilliseconds - timeMilliseconds.time

        var days = diff / daysMilliseconds
        val remainderDays = diff % daysMilliseconds
        var hours = remainderDays / hoursMilliseconds
        val remainderHours = remainderDays % hoursMilliseconds
        var minutes = remainderHours / minutesMilliseconds
        val remainderMinutes = remainderHours % minutesMilliseconds
        var seconds = remainderMinutes / secondsMilliseconds


        if (days <= 0) days = 0
        if (hours <= 0) hours = 0
        if (minutes <= 0) minutes = 0
        if (seconds <= 0)  seconds = 0

        val counter = DCounter(
            days.toString(),
            hours.toString(),
            minutes.toString(),
            seconds.toString(),
        )

        withContext(Main) {
            listener?.counter(counter)
        }
    }

    fun stopTimer(){
        stopTimer = true
    }

    fun setListener(listener: INextRaceCounter) {
        this.listener = listener
    }

    fun checkDate(date: Date):Boolean {
        val currentTime = Calendar.getInstance().time
        var result:Boolean = false
        result = currentTime.time > date.time
        return result
    }
}