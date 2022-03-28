package com.esther.mapsample.model


import com.google.gson.annotations.SerializedName

data class StepsDetail(
    @SerializedName("arrival_stop")
    val arrivalStop: ArrivalStop,
    @SerializedName("arrival_time")
    val arrivalTime: ArrivalTime,
    @SerializedName("building_level")
    val buildingLevel: BuildingLevel,
    @SerializedName("departure_stop")
    val departureStop: DepartureStop,
    @SerializedName("departure_time")
    val departureTime: DepartureTime,
    @SerializedName("distance")
    val distance: Distance,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("end_location")
    val endLocation: Location,
    @SerializedName("headsign")
    val headsign: String,
    @SerializedName("html_instructions")
    val htmlInstructions: String,
    @SerializedName("line")
    val line: Line,
    @SerializedName("maneuver")
    val maneuver: String,
    @SerializedName("num_stops")
    val numStops: Int,
    @SerializedName("polyline")
    val polyline: Polyline,
    @SerializedName("start_location")
    val startLocation: Location,
    @SerializedName("travel_mode")
    val travelMode: String,
    @SerializedName("trip_short_name")
    val tripShortName: String
)