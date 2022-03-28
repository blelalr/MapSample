package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class Agency(
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("url")
    val url: String
)