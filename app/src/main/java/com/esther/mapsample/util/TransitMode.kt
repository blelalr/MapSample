package com.esther.mapsample.util


enum class TransitMode(val mode: String) {
    Train("train"),
    Tram("tram"),
    Bus("bus"),
    Driving("driving"),
    Cycling("cycling"),
    Walk("walk"),
    Subway("subway");

    companion object {
        fun from(value: String): TransitMode =  requireNotNull(values().find { it.mode == value }) { "No TransitMode with value $value" }
    }
}
