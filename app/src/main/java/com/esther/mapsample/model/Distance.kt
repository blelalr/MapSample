package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class Distance(
    @SerializedName("text")
    val text: String,
    @SerializedName("value")
    val value: Int
)