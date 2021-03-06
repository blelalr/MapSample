package com.esther.mapsample.model


import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class Transit(
    @SerializedName("ended_on")
    val endedOn: Long,
    @SerializedName("estimated_time")
    val estimatedTime: Int,
    @SerializedName("fare_status")
    val fareStatus: Int,
    @SerializedName("mode")
    val mode: String,
    @SerializedName("started_on")
    val startedOn: Long,
    @SerializedName("steps")
    val steps: List<Step>,
    @SerializedName("total_price")
    val totalPrice: Int,
    @SerializedName("trip_detail_uuid")
    val tripDetailUuid: String
)

class TransitMockData {

    private val gson = Gson()

    suspend fun getTransit(): Transit {
        val typeToken = object : TypeToken<Transit>(){}.type
        return gson.fromJson(fetchTransitJsonString(), typeToken)
    }

    private fun fetchTransitJsonString(): String {
        return """{
          "trip_detail_uuid": "3c7a5e3b-67b5-4980-8454-ddc4f4579439",
          "mode": "MM",
          "total_price": 5,
          "started_on": 1627376298,
          "ended_on": 1627385733,
          "estimated_time": 157,
          "fare_status": 1,
          "steps": [
            {
              "mode": "walk",
              "mode_type": "",
              "distance": 133,
              "arrive": 1627376298,
              "estimated_time": 102,
              "short_name": "",
              "short_name_no": "",
              "num_stops": 0,
              "started_on": 1627376298,
              "ended_on": 1627376400,
              "ticket_status": "0",
              "is_ticket": 0,
              "price": 0,
              "delay": 0,
              "origin_name": "Missour City Pr 1 Drive, Houston, TX 77085, USA",
              "origin_no": "",
              "origin_lat": 29.62204329999999,
              "origin_lng": -95.5066488,
              "destination_name": "Missouri City P&R",
              "destination_no": "",
              "destination_lat": 29.6218553,
              "destination_lng": -95.5072374,
              "polyline": "wpxsDps|eQs@?@f@?h@?b@|@CVB",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "distance": {
                    "text": "92 ft",
                    "value": 28
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 20
                  },
                  "end_location": {
                    "lat": 29.6222959,
                    "lng": -95.5066514
                  },
                  "html_instructions": "Head <b>north</b><div style=\"font-size:0.9em\">Restricted usage road</div>",
                  "polyline": {
                    "points": "wpxsDps|eQs@?"
                  },
                  "start_location": {
                    "lat": 29.62204329999999,
                    "lng": -95.5066488
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "187 ft",
                    "value": 57
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 46
                  },
                  "end_location": {
                    "lat": 29.622286,
                    "lng": -95.50723889999999
                  },
                  "html_instructions": "Turn <b>left</b> onto <b>Missour City Pr 1 Dr</b><div style=\"font-size:0.9em\">Restricted usage road</div>",
                  "maneuver": "turn-left",
                  "polyline": {
                    "points": "krxsDps|eQ@f@?h@?b@"
                  },
                  "start_location": {
                    "lat": 29.6222959,
                    "lng": -95.5066514
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "157 ft",
                    "value": 48
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 36
                  },
                  "end_location": {
                    "lat": 29.6218553,
                    "lng": -95.5072374
                  },
                  "html_instructions": "Turn <b>left</b><div style=\"font-size:0.9em\">Restricted usage road</div><div style=\"font-size:0.9em\">Destination will be on the left</div>",
                  "maneuver": "turn-left",
                  "polyline": {
                    "points": "irxsDfw|eQ|@CVB"
                  },
                  "start_location": {
                    "lat": 29.622286,
                    "lng": -95.50723889999999
                  },
                  "travel_mode": "WALKING"
                }
              ],
              "firststop": false
            },
            {
              "mode": "bus",
              "mode_type": "",
              "distance": 9630,
              "arrive": 1627376400,
              "estimated_time": 1260,
              "short_name": "Fondren",
              "short_name_no": "63",
              "num_stops": 34,
              "started_on": 1627376400,
              "ended_on": 1627377660,
              "ticket_status": "0",
              "is_ticket": 1,
              "price": 1.25,
              "delay": 0,
              "origin_name": "Missouri City P&R",
              "origin_no": "",
              "origin_lat": 29.621844,
              "origin_lng": -95.50714699999999,
              "destination_name": "Fondren Rd @ Bellaire Blvd",
              "destination_no": "",
              "destination_lat": 29.703879,
              "destination_lng": -95.52089699999999,
              "polyline": "ooxsDtv|eQ?DyAD?|AE^wB_@wDe@aDS@OYCWAw@C{BASAwA@Y?aA@wA?c@@I?{A?E?sA?E?Q@gA@y@@e@BU@O?s@D_@@c@BUBW@[D]DWBYDE?OBaBb@WFk@LODq@Ni@F{@Lm@Bk@DiDDaA?Y?Q?{C@e@?Q?sD@M?eB?sA@cB?eA@c@?eFBqC?mA@I@oAAkA?e@?mA@kB@G?gA?q@?aABK?Y?K?k@?Y?oA?c@?yA@i@?s@?}@?uB@e@?I?a@?c@@QA}DBw@?wC?wA@kBBS?cCA[?c@?_@?cB?sD?w@@sB@[?uABi@?E?o@@k@?_@?wAAk@?U?kB@cB?uB@g@?S?_@Am@@I@y@?o@@M?_@?g@?w@?cA?kA@O?[@g@?k@?gA?S?g@?e@Ac@@Y?O?c@?_@?I?Y@yA@y@DW?mACcAAm@?aB@iB?yDFkB?S?wBAyBAw@BoB@]?cA?y@?cB@[@g@AeEBo@?g@@{E?s@@aB@mA?_@@g@@q@@qA?[?o@A]?Q?W?aB@kC?_D@sA@kE@sB?m@@O?G?_D@]?cD@Y?g@?_C@cD@[?S?qBB}B?I@wB@}@?[?U?_C@iADG?gAFC?aAHc@Do@Ha@Fc@Ha@HaCj@a@JeEfAe@Jk@N_@Je@HwEbB_@NkBbAUNUNYNcBpAwAlAIFOJgAjAa@b@wCpDg@n@YZKNMLsEtFMN{BnCgArAw@|@eAnAs@z@WXCDQRABA@MLA@A@[^k@n@_@h@CBKLKNOPQV[^]`@Y^a@f@_@b@GHGFCDABCDCBCDEDGFEFIDWVGFk@`@WPQLMHULWLUJOFKFKBKDIBMD[HEU",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "arrival_stop": {
                    "location": {
                      "lat": 29.703879,
                      "lng": -95.52089699999999
                    },
                    "name": "Fondren Rd @ Bellaire Blvd"
                  },
                  "arrival_time": {
                    "text": "4:21am",
                    "time_zone": "America/Chicago",
                    "value": 1627377660
                  },
                  "departure_stop": {
                    "location": {
                      "lat": 29.621844,
                      "lng": -95.50714699999999
                    },
                    "name": "Missouri City P&R"
                  },
                  "departure_time": {
                    "text": "4:00am",
                    "time_zone": "America/Chicago",
                    "value": 1627376400
                  },
                  "headsign": "Westheimer Rd",
                  "line": {
                    "agencies": [
                      {
                        "name": "Metropolitan Transit Authority of Harris County",
                        "phone": "1 (713) 635-4000",
                        "url": "http://www.ridemetro.org/"
                      }
                    ],
                    "color": "#004080",
                    "name": "Fondren",
                    "short_name": "63",
                    "text_color": "#ffffff",
                    "url": "https://www.ridemetro.org/MetroPDFs/Schedules/BusSchedules/n063-Fondren.pdf",
                    "vehicle": {
                      "icon": "//maps.gstatic.com/mapfiles/transit/iw2/6/bus2.png",
                      "name": "Bus",
                      "type": "BUS"
                    }
                  },
                  "num_stops": 34,
                  "trip_short_name": "FONDREN"
                }
              ],
              "firststop": false,
              "product_id": "0c31ec86-ff12-42b2-a8b8-a4132766114a",
              "product_name": "Local Single Ride"
            },
            {
              "mode": "walk",
              "mode_type": "",
              "distance": 189,
              "arrive": 1627377660,
              "estimated_time": 158,
              "short_name": "",
              "short_name_no": "",
              "num_stops": 0,
              "started_on": 1627377660,
              "ended_on": 1627377818,
              "ticket_status": "0",
              "is_ticket": 0,
              "price": 0,
              "delay": 0,
              "origin_name": "Fondren Rd @ Bellaire Blvd",
              "origin_no": "",
              "origin_lat": 29.7039091,
              "origin_lng": -95.52080749999999,
              "destination_name": "Bellaire Blvd @ Fondren Rd",
              "destination_no": "",
              "destination_lat": 29.7050395,
              "destination_lng": -95.5215534,
              "polyline": "mphtD`l_fQ[J@HDRmAPUBK@I@O@M?O@O?U@?N?H?N?^",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "distance": {
                    "text": "56 ft",
                    "value": 17
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 12
                  },
                  "end_location": {
                    "lat": 29.7040539,
                    "lng": -95.52087209999999
                  },
                  "html_instructions": "Head <b>north</b> toward <b>Fondren Rd</b>",
                  "polyline": {
                    "points": "mphtD`l_fQ[J"
                  },
                  "start_location": {
                    "lat": 29.7039091,
                    "lng": -95.52080749999999
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "62 ft",
                    "value": 19
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 15
                  },
                  "end_location": {
                    "lat": 29.7040087,
                    "lng": -95.521022
                  },
                  "html_instructions": "Turn <b>left</b> toward <b>Fondren Rd</b>",
                  "maneuver": "turn-left",
                  "polyline": {
                    "points": "iqhtDll_fQ@HDR"
                  },
                  "start_location": {
                    "lat": 29.7040539,
                    "lng": -95.52087209999999
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "397 ft",
                    "value": 121
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 88
                  },
                  "end_location": {
                    "lat": 29.7050431,
                    "lng": -95.52125919999999
                  },
                  "html_instructions": "Turn <b>right</b> onto <b>Fondren Rd</b>",
                  "maneuver": "turn-right",
                  "polyline": {
                    "points": "aqhtDjm_fQmAPUBK@I@O@M?O@O?U@?N"
                  },
                  "start_location": {
                    "lat": 29.7040087,
                    "lng": -95.521022
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "105 ft",
                    "value": 32
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 43
                  },
                  "end_location": {
                    "lat": 29.7050395,
                    "lng": -95.5215534
                  },
                  "html_instructions": "Turn <b>left</b> onto <b>Bellaire Blvd</b>",
                  "maneuver": "turn-left",
                  "polyline": {
                    "points": "owhtDzn_fQ?H?N?^"
                  },
                  "start_location": {
                    "lat": 29.7050431,
                    "lng": -95.52125919999999
                  },
                  "travel_mode": "WALKING"
                }
              ],
              "firststop": false
            },
            {
              "mode": "bus",
              "mode_type": "",
              "distance": 11773,
              "arrive": 1627378040,
              "estimated_time": 1960,
              "short_name": "Bellaire",
              "short_name_no": "2",
              "num_stops": 42,
              "started_on": 1627377818,
              "ended_on": 1627380000,
              "ticket_status": "0",
              "is_ticket": 1,
              "price": 1.25,
              "delay": 0,
              "origin_name": "Bellaire Blvd @ Fondren Rd",
              "origin_no": "",
              "origin_lat": 29.705013,
              "origin_lng": -95.521553,
              "destination_name": "Texas Medical Center Transit Center",
              "destination_no": "",
              "destination_lat": 29.704328,
              "destination_lng": -95.40361999999999,
              "polyline": "iwhtDtp_fQM??g@?Y?eCAkA?[?k@?_BAiA?wAAwB?a@CY?u@A]Bq@?K@UDaADm@J}A@QPkB@GHe@P_AJg@@GDQDSBGHc@V}@Nk@?AH[@?Ja@?ANi@XmBLy@Hu@Dc@D[B_@JmBF}BBeA?eAAo@Ca@Ae@IyAEm@CYCUCSE_@Im@K{@EUAEG]I_@EUUaAKc@I[Us@_@sAGSGQMm@CMG]EUE[E[G[Ge@Ea@E]KsAIeACg@Cw@A]?[?a@AM?_@?kA?qACeD?g@?gA?cBAw@AoDAQ?_@?m@AwECcE@aB?kAA_C?g@?s@Ao@AuAC{C?cB?gACoEAwB?S?eA?oE?s@?aAAY?{@AmA?c@AgAAqA?k@?]?}@?YAyEAiB?}@?UAgE?}@A}@@}ACkEAwB?S?eA?sB?qACmB?w@?o@?WAoA?[AyA@UAk@?oC?_B?AAgC?gAA[?i@?kA?cF?uAC{BAk@@IK_@OYCMAu@EmA\\G\\U@w@@]CsEC}MA}A?_@AG?oAC}@I_AIiAAWCyEAkA?{@AeAA_A?y@?A?E?A?g@?A?E?A?_A@y@AeBCqE@}C?o@?}@?i@CsEA}C?kB?KCeF?_B?Q?o@?i@C}B?O?IA_CAwB?e@?_@?yA?aAA}@?I?e@?WAi@AoC?_AAgC?iGCeC?GAy@?kC?a@?_AC{B?_A?qA?O?G?aB?E?c@AgB?yA?YAoC?[?s@AwDAsA?y@AmE?kA?W?[?SA]A{B?kE?gB?Y?u@?g@AgCAwA?O?cA?S?yBAwB?e@?a@?o@?cBAcBAgB?iC?eC?Q?sD?y@?_@?c@EyM?yA?CAUA_C@iAAU?eB@[Ae@?y@AiECoH?{@?[?wA?]AeE?WAU?kA?oA?qAAqB?qA?wE?uB?mCAaA?g@?sB?{A?iA?QAo@AK?kA?qA?Q?C?A?Y?G?M?iBA_BAeA?MAaAj@?lB?b@?\\??LBHDJBBDBVLDG@C@APEb@I`@GJbA",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "arrival_stop": {
                    "location": {
                      "lat": 29.704328,
                      "lng": -95.40361999999999
                    },
                    "name": "Texas Medical Center Transit Center"
                  },
                  "arrival_time": {
                    "text": "5:00am",
                    "time_zone": "America/Chicago",
                    "value": 1627380000
                  },
                  "departure_stop": {
                    "location": {
                      "lat": 29.705013,
                      "lng": -95.521553
                    },
                    "name": "Bellaire Blvd @ Fondren Rd"
                  },
                  "departure_time": {
                    "text": "4:27am",
                    "time_zone": "America/Chicago",
                    "value": 1627378040
                  },
                  "headsign": "TMC TC",
                  "line": {
                    "agencies": [
                      {
                        "name": "Metropolitan Transit Authority of Harris County",
                        "phone": "1 (713) 635-4000",
                        "url": "http://www.ridemetro.org/"
                      }
                    ],
                    "color": "#004080",
                    "name": "Bellaire",
                    "short_name": "2",
                    "text_color": "#ffffff",
                    "url": "https://www.ridemetro.org/MetroPDFs/Schedules/BusSchedules/n002-Bellaire.pdf",
                    "vehicle": {
                      "icon": "//maps.gstatic.com/mapfiles/transit/iw2/6/bus2.png",
                      "name": "Bus",
                      "type": "BUS"
                    }
                  },
                  "num_stops": 42,
                  "trip_short_name": "BELLAIRE"
                }
              ],
              "firststop": false,
              "product_id": "0c31ec86-ff12-42b2-a8b8-a4132766114a",
              "product_name": "Local Single Ride"
            },
            {
              "mode": "walk",
              "mode_type": "",
              "distance": 68,
              "arrive": 1627380000,
              "estimated_time": 58,
              "short_name": "",
              "short_name_no": "",
              "num_stops": 0,
              "started_on": 1627380000,
              "ended_on": 1627380058,
              "ticket_status": "0",
              "is_ticket": 0,
              "price": 0,
              "delay": 0,
              "origin_name": "Texas Medical Center Transit Center",
              "origin_no": "",
              "origin_lat": 29.7037772,
              "origin_lng": -95.40301339999999,
              "destination_name": "TMC Transit Center",
              "destination_no": "",
              "destination_lat": 29.7037615,
              "destination_lng": -95.4028246,
              "polyline": "sohtDxkheQHACO?EAM",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "distance": {
                    "text": "30 ft",
                    "value": 9
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 6
                  },
                  "end_location": {
                    "lat": 29.7037459,
                    "lng": -95.40292269999999
                  },
                  "html_instructions": "Head <b>south</b> on <b>Fannin St</b> toward <b>Pressler St</b>",
                  "polyline": {
                    "points": "sohtDxkheQHACO"
                  },
                  "start_location": {
                    "lat": 29.7037772,
                    "lng": -95.40301339999999
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "46 ft",
                    "value": 14
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 20
                  },
                  "end_location": {
                    "lat": 29.7037615,
                    "lng": -95.4028246
                  },
                  "html_instructions": "Turn <b>left</b> onto <b>Pressler St</b>",
                  "maneuver": "turn-left",
                  "polyline": {
                    "points": "mohtDfkheQ?EAM"
                  },
                  "start_location": {
                    "lat": 29.7037459,
                    "lng": -95.40292269999999
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "148 ft",
                    "value": 45
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 32
                  },
                  "end_location": {
                    "lat": 29.7037615,
                    "lng": -95.4028246
                  },
                  "html_instructions": "Turn <b>left</b><div style=\"font-size:0.9em\">Destination will be on the right</div>",
                  "maneuver": "turn-left",
                  "polyline": {
                    "points": "oohtDrjheQ"
                  },
                  "start_location": {
                    "lat": 29.7037615,
                    "lng": -95.4028246
                  },
                  "travel_mode": "WALKING"
                }
              ],
              "firststop": false
            },
            {
              "mode": "tram",
              "mode_type": "",
              "distance": 6245,
              "arrive": 1627380360,
              "estimated_time": 960,
              "short_name": "Metrorail Red Line",
              "short_name_no": "Red",
              "num_stops": 8,
              "started_on": 1627380058,
              "ended_on": 1627381320,
              "ticket_status": "0",
              "is_ticket": 1,
              "price": 1.25,
              "delay": 0,
              "origin_name": "TMC Transit Center",
              "origin_no": "",
              "origin_lat": 29.70413,
              "origin_lng": -95.402847,
              "destination_name": "Downtown Transit Center NB",
              "destination_no": "",
              "destination_lat": 29.7506078,
              "destination_lng": -95.3699642,
              "polyline": "yqhtDxjheQ@PSBc@Fi@Do@FO?g@?_@?u@?oA?S?YAC?W?G?_@AY?UAYEYGYIMIUMKIQMm@c@e@]MOQQa@c@UOkBsAq@g@s@i@gCiBe@]mDiCy@m@ECWSMIaAs@IGWUCAMKOKIEg@c@QMSOMIk@_@ACo@c@k@c@MIQOUQi@_@MKAAm@e@w@i@k@e@u@g@i@_@QOWQc@[]U[UQMi@][U[Sk@Yk@Wi@W{@Yy@W}@Ui@QOEOGYK]Qc@Se@Ug@[c@Y]Wu@k@QMw@k@w@k@mBwA_BkAYS]UAAYUSQOSMQMSISISEMCMGUAGKk@CO[iB?AQeAOk@K]EMEIGKCEKQCEAGCEACCCQOOQYW{@q@A?EEuAcAIEiA{@KKuB_Bu@k@k@c@cAu@oAcAMMsBoAa@YaBmAYS_BmAOKaCgBKIuBwAo@g@KCMAUAc@CQ@U?S@Q@sALUBS@E?Q?C?K?A?QCQAkASUEs@MaAQk@KgAUm@KMEICIEAAEAKGKEaBkAgAu@yAiA}C{BuAeA_FoDIGOM}BgB{CwBgAw@GGy@m@iBoAkEaDmVuQEC_Aq@k@c@}B_Bi@a@gBqAeCgBMKcCcBe@_@{AiAYSyBcBWSEAcAw@CD",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "arrival_stop": {
                    "location": {
                      "lat": 29.7506078,
                      "lng": -95.3699642
                    },
                    "name": "Downtown Transit Center NB"
                  },
                  "arrival_time": {
                    "text": "5:22am",
                    "time_zone": "America/Chicago",
                    "value": 1627381320
                  },
                  "departure_stop": {
                    "location": {
                      "lat": 29.70413,
                      "lng": -95.402847
                    },
                    "name": "TMC Transit Center"
                  },
                  "departure_time": {
                    "text": "5:06am",
                    "time_zone": "America/Chicago",
                    "value": 1627380360
                  },
                  "headsign": "Northline TC",
                  "line": {
                    "agencies": [
                      {
                        "name": "Metropolitan Transit Authority of Harris County",
                        "phone": "1 (713) 635-4000",
                        "url": "http://www.ridemetro.org/"
                      }
                    ],
                    "color": "#e60f33",
                    "name": "Metrorail Red Line",
                    "short_name": "Red",
                    "text_color": "#ffffff",
                    "url": "https://www.ridemetro.org/Pages/RedLine.aspx",
                    "vehicle": {
                      "icon": "//maps.gstatic.com/mapfiles/transit/iw2/6/tram2.png",
                      "name": "Light rail",
                      "type": "TRAM"
                    }
                  },
                  "num_stops": 8
                }
              ],
              "firststop": false,
              "product_id": "0c31ec86-ff12-42b2-a8b8-a4132766114a",
              "product_name": "Local Single Ride"
            },
            {
              "mode": "walk",
              "mode_type": "",
              "distance": 87,
              "arrive": 1627381320,
              "estimated_time": 64,
              "short_name": "",
              "short_name_no": "",
              "num_stops": 0,
              "started_on": 1627381320,
              "ended_on": 1627381384,
              "ticket_status": "0",
              "is_ticket": 0,
              "price": 0,
              "delay": 0,
              "origin_name": "Downtown Transit Center NB",
              "origin_no": "",
              "origin_lat": 29.7508392,
              "origin_lng": -95.3696969,
              "destination_name": "St Joseph Pkwy @ Main St",
              "destination_no": "",
              "destination_lat": 29.75021749999999,
              "destination_lng": -95.3699554,
              "polyline": "wuqtDr{aeQr@d@NWl@d@B?@?@?@?",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "distance": {
                    "text": "115 ft",
                    "value": 35
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 24
                  },
                  "end_location": {
                    "lat": 29.750579,
                    "lng": -95.3698946
                  },
                  "html_instructions": "Head <b>southwest</b> on <b>Main St</b>",
                  "polyline": {
                    "points": "wuqtDr{aeQr@d@"
                  },
                  "start_location": {
                    "lat": 29.7508392,
                    "lng": -95.3696969
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "49 ft",
                    "value": 15
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 12
                  },
                  "end_location": {
                    "lat": 29.7504989,
                    "lng": -95.3697739
                  },
                  "html_instructions": "Turn <b>left</b>",
                  "maneuver": "turn-left",
                  "polyline": {
                    "points": "ctqtDx|aeQNW"
                  },
                  "start_location": {
                    "lat": 29.750579,
                    "lng": -95.3698946
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "121 ft",
                    "value": 37
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 28
                  },
                  "end_location": {
                    "lat": 29.75021749999999,
                    "lng": -95.3699554
                  },
                  "html_instructions": "Turn <b>right</b><div style=\"font-size:0.9em\">Destination will be on the right</div>",
                  "maneuver": "turn-right",
                  "polyline": {
                    "points": "ssqtD`|aeQl@d@B?@?@?@?"
                  },
                  "start_location": {
                    "lat": 29.7504989,
                    "lng": -95.3697739
                  },
                  "travel_mode": "WALKING"
                }
              ],
              "firststop": false
            },
            {
              "mode": "bus",
              "mode_type": "",
              "distance": 41886,
              "arrive": 1627381957,
              "estimated_time": 2843,
              "short_name": "Bush IAH Express",
              "short_name_no": "102",
              "num_stops": 34,
              "started_on": 1627381384,
              "ended_on": 1627384800,
              "ticket_status": "0",
              "is_ticket": 1,
              "price": 1.25,
              "delay": 0,
              "origin_name": "St Joseph Pkwy @ Main St",
              "origin_no": "",
              "origin_lat": 29.750178,
              "origin_lng": -95.370002,
              "destination_name": "Bush IAH Terminal C",
              "destination_no": "",
              "destination_lat": 29.98602899999999,
              "destination_lng": -95.33794499999999,
              "polyline": "sqqtDn}aeQLJQVCFCJEFCFk@lAMXMRU`@i@_@c@[MI}@o@y@q@]Wy@o@k@c@i@]SOQM]U_As@WS[W]WOKw@k@s@i@WQiAy@o@e@]WuB}A_@WuB}A]U{@o@y@o@IGCAOKAAaAq@oAaAwAeA]WKIKIIGy@m@qA}@EEyBaBa@[_BmA{@o@[Uk@_@g@]QMUO[Sm@c@_@Yk@a@eBmAECi@_@_@[UUYWoA_@y@CK@q@@U?Q@G?A?W@s@Ba@BE@c@@c@@aADU@]D]Fg@PC?G@C@g@LODMDGBC?GBOHQF]Rg@b@MPIJc@r@U`@EHy@xAi@`AeAhBOTMTMPILMLA@WXSRIHMJOJGD]VEBCDEJmB~@m@ZeAj@iB~@kAn@IDo@Xa@TmClAuB~@e@Rc@Te@TWL_@R_@PSJm@TC@[JIBYHC@]HE@a@H]FSBM@wEd@a@Dy@H}AJkAT}@?oAB_ABs@@kBBC?oCDw@@S?aBB[@]@g@BWBm@De@FcAPWFYJC@s@VmAf@MF[Na@Rq@b@g@X_EdCwAx@qAv@_B|@e@Vm@X]Lg@No@Lq@Lg@Fo@Bm@BmA@iB@uA?o@?aBCsCKkBCW?_B?qA?c@?k@?[@cG?_A@i@?]?eB?u@?u@?}@?C?E?I?C?A?O@E?{@?q@@q@?kBDw@@_@B{@DcAHqD\\mCZwFn@a@FC?QBA?]DA?OBE?A@kALmCZYDk@FgALu@HOBi@F}ANgALYBA??@WBE@OBA?]DeANm@J{AVA?_@He@JQDy@RuD~@[Rw@Ts@TcAX_@LiAZgDbAk@Pm@R}Ad@UFKDgBf@o@RMB{@XkErAcBh@s@Rq@RIBWHe@F{FzB}@^C@A?OFEBC@[Li@RwBz@[LUHu@XcA`@i@Ta@NC@s@X[LsBt@}@VSHq@Py@TsAXMBi@Jc@H_BV{@LiDb@gDd@e@FeANk@Hm@Js@La@Jw@PWHSFUHQFy@XUJWJa@T[NSLUJk@^q@b@m@d@qBxAoBxAe@\\u@j@w@h@uAbAc@\\g@^GDa@Zq@f@{@n@s@h@a@ZQNm@b@_@VC@_@X_@VeAr@eAp@{BrAcFtCeAl@w@b@u@b@{@d@_Af@eAn@wAv@w@b@iAn@{@f@gAl@q@`@YLiB`AKDKFgCxAaB~@gAn@a@Vi@ZSLGBUNA?]TYPc@VgAp@KF_@V]RCBa@VUNWNWPk@^YTi@\\SLmAx@QLaAl@CByMnIwOxJIFuMhIkKxGsAx@e@XiCzAQDyAr@UJa@PQHa@Ny@^g@R}CnAEB}@^s@X_@P{B|@wAj@QHuBz@iDtAwH~CoHvCw@\\_Bp@g@PgGfCgAb@a@NaA`@_@PA@{BdAc@TcAh@QJMFQHgAp@cDjB]Pi@Xs@\\e@Tg@PgAZcBb@_BZcAPaB^{Cr@oB\\UFkB^o@JuBRw@Fi@Bm@@K?C?Q?eHHaA@aGDaFBoJ@w@?mB@gA?aCBc@?iBBW?A?a@?A?K@M?A?]?[?M?aC@wB@kAAoCBc@?sDBwEDiB@uDBaB@_@?aA?eDBc@?eBBeA?gA@qDB_EBmB@cA@_@?o@@iD@yi@VeJFuHDgA@sD@c@?uA@A?_@?_@@C?]?A?a@@A?A?E?E?oC@oB@kAAkAAMIGAKCKAeAKeCSC?C?AAC?CAE?UKyAEiAEoBEmAEuBEC?c@Ac@CsBG_AAM?iBGeCGo@CaACe@AeCIwCIaCE}ACs@CU?iBGuBGK?O?}AEC?mBYGAkAKu@Cc@?q@?mAAA?O?I?M@U?g@Cy@?_@?E?oB?}@Bu@B}@DaBLOBe@JaC^cGx@kFr@e@H?a@AmAAy@?w@AsCAyCA{@Cc@KaAAIIa@E]C_@Ai@?c@?A?iAgCDiBBwBAG?GG?AA?MAIAM?I?W?E?A?G?Y?E?WAA?A?G?W?A?G?U?}@@W?K?U?a@?A?m@@iB@e@?iA@wBDU?iABe@Dy@FgANo@Na@NURg@PQFGByAp@YNQJ}@l@KHO@A?A@]V[Xi@h@ML]ZyArAs@p@g@f@uCbBiA^s@VKg@O}AO_BAqACaCAaA?q@AkB@YA}B?}@?cACqA?iAAa@@s@AI?OAkA@]?k@?I?]A_@?_BAyAAmC?c@EmBAw@CwD@}CRI|Ag@FCx@]`@UjAs@^YXUzAqAx@u@\\YTU|@s@@Af@c@fAu@v@e@d@YZMpA]p@M`@Ix@Op@GJERETCf@G^CVATARAT?f@@h@BbBTnAXjAVjAV|A\\TFl@Lf@NVFv@Rf@HfB`@VFLBh@LRD@@b@JLi@NoAF[?CF]XiBReBB[@CB_@Fk@Bo@@OBo@DyA?}@Ae@?oBAkB?c@AwDAiC?_A?eAA_AAEAA?A?AAAWgFAe@AUCwAAq@AS?C?A?AAA?AAA?AAAAAGGCyB?sA?mAA{BAm@AkDAiA?I?_@?m@?IAO?Q?A@G?]?{AAqB?K?]?CAa@?C?e@?M?U?S?s@A]?a@?I?I?uA?i@AW?cA?eAAeA?gB?[@}B?cIAUCqN?mBA}CCkI?cBMwm@?_AAyD?uE?W?wAAaLAwB?cCAoKAi@?yBA[CiN?}C?qACmIAqG?y@?a@IwU?iNAcBJc@?G?E@S@m@FiD@{@@}@AuCAuIA}B?{@A_@AUE]ESCQGQGUIUGMOWS]CEY]UUWQECKGOGMIWGAAICIAQEWCQCO?S?qA?cB?wA@aB?cACe@A_AC_ACmAAGACAKCM?aE?iA@M?I?E?QAY?Y?a@?w@?iC@_EB_@?]?[?U?aA@Q?G?a@?[?aC@oC@]?U?i@?S?eA@sG@a@@]?i@A_AAaAScAUgCa@c@Gu@Ki@Eq@E[A[?K?O?]@M?S@U@]B_@BMBe@J_@FaB\\o@Ta@LWJk@Xm@^w@h@o@b@_@Ti@ZmE|Bq@\\KFGB]ROHcFhCsBdAi@ZKDo@\\OHuDrB_A`@SHSJw@b@]P}BhAEBaAf@oAp@eG~COHKH_Ad@_@R_Bv@IDiFlCm@^kAl@_@PYLYLe@VwAx@sC`BQVEDKHgAv@WPEBo@r@WLcAh@MFoBbAUL]Na@Rg@Pe@Ne@J_@HOBkAJo@@m@@q@Cm@E]EGA_@E[GUG[Ua@Qe@Qm@YUMUQMIMOIKW_@_@y@iAkCUi@M[Sc@qAaDQc@Ka@Mu@UkB@eB?_A?C@u@Bk@Ba@B]?AFe@?EFa@D_@?GFk@Di@D{@@i@@a@?G@sA?k@?k@AsG?qAAoE?sA?m@?o@?s@Hu@Bi@?WDwBDwA?m@?UAUAOCWE[Ic@Qi@KYYi@MUc@c@US]USI]KUIWEa@EYAMAY@M@O@A?WDYFYHYLA@GB_@X]TEDqCtBy@n@UPWVIHA?c@d@W^q@rAO^INEFMLq@fAs@fAg@v@QZ[p@[|@Sr@G|@Bp@Dn@@HHz@?BFf@@JB\\?BB\\BtC?Z?lEAxB?t@ChAc@nCI|BCpI?D?l@DxFDnCAVBL@FBHFJFHHHHDDBB@B?D@H@F@l@?Z?PAF?HAFCHEFEFEDEHUBG@G@G@E@K?Q@_@@g@?M@W@OBMBIBoA@_D?o@?A?uA@UMA",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "arrival_stop": {
                    "location": {
                      "lat": 29.98602899999999,
                      "lng": -95.33794499999999
                    },
                    "name": "Bush IAH Terminal C"
                  },
                  "arrival_time": {
                    "text": "6:20am",
                    "time_zone": "America/Chicago",
                    "value": 1627384800
                  },
                  "departure_stop": {
                    "location": {
                      "lat": 29.750178,
                      "lng": -95.370002
                    },
                    "name": "St Joseph Pkwy @ Main St"
                  },
                  "departure_time": {
                    "text": "5:32am",
                    "time_zone": "America/Chicago",
                    "value": 1627381957
                  },
                  "headsign": "Bush IAH Terminal C",
                  "line": {
                    "agencies": [
                      {
                        "name": "Metropolitan Transit Authority of Harris County",
                        "phone": "1 (713) 635-4000",
                        "url": "http://www.ridemetro.org/"
                      }
                    ],
                    "color": "#004080",
                    "name": "Bush IAH Express",
                    "short_name": "102",
                    "text_color": "#ffffff",
                    "url": "https://www.ridemetro.org/MetroPDFs/Schedules/BusSchedules/n102-Bush-IAH-Express.pdf",
                    "vehicle": {
                      "icon": "//maps.gstatic.com/mapfiles/transit/iw2/6/bus2.png",
                      "name": "Bus",
                      "type": "BUS"
                    }
                  },
                  "num_stops": 34,
                  "trip_short_name": "BUSHIAH"
                }
              ],
              "firststop": false,
              "product_id": "0c31ec86-ff12-42b2-a8b8-a4132766114a",
              "product_name": "Local Single Ride"
            },
            {
              "mode": "walk",
              "mode_type": "",
              "distance": 1253,
              "arrive": 1627384800,
              "estimated_time": 933,
              "short_name": "",
              "short_name_no": "",
              "num_stops": 0,
              "started_on": 1627384800,
              "ended_on": 1627385733,
              "ticket_status": "0",
              "is_ticket": 0,
              "price": 0,
              "delay": 0,
              "origin_name": "Bush IAH Terminal C",
              "origin_no": "",
              "origin_lat": 29.98596479999999,
              "origin_lng": -95.33794329999999,
              "destination_name": "2800 N Terminal Rd, Houston, TX 77032, USA",
              "destination_no": "",
              "destination_lat": 29.9867823,
              "destination_lng": -95.3499576,
              "polyline": "gs_vDbu{dQAV?tA?p@A~CCnA?V?t@?h@?rAAf@?h@?h@?h@?f@?j@?TAn@A^Gj@Gv@AX?H?H@JBHBzE@nDArC?lA?b@Ab@ChA?tC?D@vDDfDI@c@Bk@BUFQ?C?IM",
              "is_puyuma": false,
              "station_arr": [],
              "ticket_uuid": "",
              "ringtong_setting": [],
              "steps_detail": [
                {
                  "distance": {
                    "text": "0.5 mi",
                    "value": 860
                  },
                  "duration": {
                    "text": "11 mins",
                    "value": 633
                  },
                  "end_location": {
                    "lat": 29.986073,
                    "lng": -95.3468542
                  },
                  "html_instructions": "Head <b>west</b> on <b>S Terminal Rd</b>",
                  "polyline": {
                    "points": "gs_vDbu{dQAV?tA?p@A~CCnA?V?t@?h@?rAAf@?h@?h@?h@?f@?j@?TAn@A^Gj@Gv@AX?H?H@JBHBzE@nDArC?lA?b@"
                  },
                  "start_location": {
                    "lat": 29.98596479999999,
                    "lng": -95.33794329999999
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "0.2 mi",
                    "value": 298
                  },
                  "duration": {
                    "text": "4 mins",
                    "value": 217
                  },
                  "end_location": {
                    "lat": 29.9860601,
                    "lng": -95.3499437
                  },
                  "html_instructions": "Slight <b>right</b>",
                  "maneuver": "turn-slight-right",
                  "polyline": {
                    "points": "}s_vDxl}dQAb@ChA?tC?D@vDDfD"
                  },
                  "start_location": {
                    "lat": 29.986073,
                    "lng": -95.3468542
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "distance": {
                    "text": "82 ft",
                    "value": 25
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 19
                  },
                  "end_location": {
                    "lat": 29.9862858,
                    "lng": -95.3499671
                  },
                  "html_instructions": "Turn <b>right</b>",
                  "maneuver": "turn-right",
                  "polyline": {
                    "points": "{s_vDb`~dQI@c@B"
                  },
                  "start_location": {
                    "lat": 29.9860601,
                    "lng": -95.3499437
                  },
                  "travel_mode": "WALKING"
                },
                {
                  "building_level": {
                    "number": 0
                  },
                  "distance": {
                    "text": "230 ft",
                    "value": 70
                  },
                  "duration": {
                    "text": "1 min",
                    "value": 64
                  },
                  "end_location": {
                    "lat": 29.9867823,
                    "lng": -95.3499576
                  },
                  "html_instructions": "Walk for 230&nbsp;ft",
                  "polyline": {
                    "points": "iu_vDh`~dQk@BUFQ?C?IM"
                  },
                  "start_location": {
                    "lat": 29.9862858,
                    "lng": -95.3499671
                  },
                  "travel_mode": "WALKING"
                }
              ],
              "firststop": false
            }
          ]
        }""".trimIndent()
    }
}