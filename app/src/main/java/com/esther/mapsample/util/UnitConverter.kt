package com.esther.mapsample.util

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

    fun unitTimeToMin(arrive: Int): String {
        return "11"
    }
}