package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.domain.model.pond.PondGrowthPrediction

data class PondGrowthPredictionDto(
    val growthLength: Float,
    val growthFeed: Float,
    val growthDays: Float,
) {
    fun toPondGrowthPrediction(): PondGrowthPrediction {
        return PondGrowthPrediction(
            growthLength = growthLength,
            growthFeed = growthFeed,
            growthDays = growthDays
        )
    }
}
