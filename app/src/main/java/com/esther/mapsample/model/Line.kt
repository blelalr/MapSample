package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class Line(
    @SerializedName("agencies")
    val agencies: List<Agency>,
    @SerializedName("color")
    val color: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("short_name")
    val shortName: String,
    @SerializedName("text_color")
    val textColor: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("vehicle")
    val vehicle: Vehicle
)