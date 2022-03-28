package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class Polyline(
    @SerializedName("points")
    val points: String
)