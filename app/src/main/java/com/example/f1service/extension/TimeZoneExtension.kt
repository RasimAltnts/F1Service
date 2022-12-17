package com.example.f1service.extension


import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.*
import java.util.*

fun ZonedDateTime.timezone(timezone: String): Date {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.forLanguageTag("TR"))
    simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date: Date = simpleDateFormat.parse(timezone) as Date
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return date
}

@SuppressLint("SimpleDateFormat")
fun ZonedDateTime.toString(timezone: Date):String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return simpleDateFormat.format(timezone)
}

fun ZonedDateTime.time(date:String,time:String):Date {
    val timezone = "${date} ${time.subSequence(0, 8)}"
    return ZonedDateTime.now().timezone(timezone)
}


fun ZonedDateTime.compareDate(date: Date):Boolean {
    var result:Boolean = true
    val calendar = Calendar.getInstance()
    val currentDate = calendar.time
    val compare = date.compareTo(currentDate)
    result = 0 >= compare
    return result
}
