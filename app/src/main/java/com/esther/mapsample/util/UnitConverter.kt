package com.esther.mapsample.util

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.*

object UnitConverter {

    fun meterToMiles(meters: Int): String {
        return String.format("%.3f", meters*0.000621371192)
    }

    fun sceToMin(sec: Int): String {
        return if((sec % 3600) / 60 < 1) {
            "$sec sec"
        } else {
            "${((sec % 3600) / 60)} min"
        }

    }

    fun unixTimeToMin(unixTime: Int): String {
        return "11"
    }

    fun unixTimeToDisplayTime(unixTime: Long): String {
        val sdf = SimpleDateFormat("hh:mm a")
        val netDate = Date(unixTime)
        val date =sdf.format(netDate)
        return date.toString()
    }
}