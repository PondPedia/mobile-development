package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.domain.model.pond.PondGrowthPrediction

data class PondGrowthPredictionDto(
    val growthDate: String,
    val growthLength: Float,
    val growthWeight: Float,
) {
    fun toPondWater(): PondGrowthPrediction {
        return PondGrowthPrediction(
            growthDate = growthDate,
            growthLength = growthLength,
            growthWeight = growthWeight
        )
    }
}
