package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class Transit(
    @SerializedName("ended_on")
    val endedOn: Int,
    @SerializedName("estimated_time")
    val estimatedTime: Int,
    @SerializedName("fare_status")
    val fareStatus: Int,
    @SerializedName("mode")
    val mode: String,
    @SerializedName("started_on")
    val startedOn: Int,
    @SerializedName("steps")
    val steps: List<Step>,
    @SerializedName("total_price")
    val totalPrice: Int,
    @SerializedName("trip_detail_uuid")
    val tripDetailUuid: String
)