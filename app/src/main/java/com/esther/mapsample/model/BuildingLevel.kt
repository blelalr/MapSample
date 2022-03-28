package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class BuildingLevel(
    @SerializedName("number")
    val number: Int
)