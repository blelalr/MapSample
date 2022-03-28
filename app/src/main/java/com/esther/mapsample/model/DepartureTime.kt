package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class DepartureTime(
    @SerializedName("text")
    val text: String,
    @SerializedName("time_zone")
    val timeZone: String,
    @SerializedName("value")
    val value: Int
)