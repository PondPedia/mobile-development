package com.aetherized.compose.pondpedia.data.remote.response

import com.aetherized.compose.pondpedia.data.remote.dto.PondWaterPredictionDto
import com.google.gson.annotations.SerializedName

data class WaterPredictionResponse (
    @SerializedName("success")
    val status: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("listWaterData")
    val data: List<PondWaterPredictionDto>
)