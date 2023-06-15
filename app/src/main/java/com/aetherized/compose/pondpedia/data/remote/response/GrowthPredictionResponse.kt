package com.aetherized.compose.pondpedia.data.remote.response

import com.aetherized.compose.pondpedia.data.remote.dto.PondGrowthPredictionDto
import com.google.gson.annotations.SerializedName

data class GrowthPredictionResponse (
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("listHarvestData")
    val data: List<PondGrowthPredictionDto>
)