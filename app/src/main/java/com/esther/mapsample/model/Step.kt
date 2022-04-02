package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("arrive")
    val arrive: Int,
    @SerializedName("delay")
    val delay: Int,
    @SerializedName("destination_lat")
    val destinationLat: Double,
    @SerializedName("destination_lng")
    val destinationLng: Double,
    @SerializedName("destination_name")
    val destinationName: String,
    @SerializedName("destination_no")
    val destinationNo: String,
    @SerializedName("distance")
    val distance: Int,
    @SerializedName("ended_on")
    val endedOn: Long,
    @SerializedName("estimated_time")
    val estimatedTime: Int,
    @SerializedName("firststop")
    val firststop: Boolean,
    @SerializedName("is_puyuma")
    val isPuyuma: Boolean,
    @SerializedName("is_ticket")
    val isTicket: Int,
    @SerializedName("mode")
    val mode: String,
    @SerializedName("mode_type")
    val modeType: String,
    @SerializedName("num_stops")
    val numStops: Int,
    @SerializedName("origin_lat")
    val originLat: Double,
    @SerializedName("origin_lng")
    val originLng: Double,
    @SerializedName("origin_name")
    val originName: String,
    @SerializedName("origin_no")
    val originNo: String,
    @SerializedName("polyline")
    val polyline: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("product_id")
    val productId: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("ringtong_setting")
    val ringtongSetting: List<Any>,
    @SerializedName("short_name")
    val shortName: String,
    @SerializedName("short_name_no")
    val shortNameNo: String,
    @SerializedName("started_on")
    val startedOn: Long,
    @SerializedName("station_arr")
    val stationArr: List<Any>,
    @SerializedName("steps_detail")
    val stepsDetail: List<StepsDetail>,
    @SerializedName("ticket_status")
    val ticketStatus: String,
    @SerializedName("ticket_uuid")
    val ticketUuid: String
)