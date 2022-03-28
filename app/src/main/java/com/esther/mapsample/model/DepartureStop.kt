package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class DepartureStop(
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String
)