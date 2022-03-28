package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class Vehicle(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)