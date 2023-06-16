package com.aetherized.compose.pondpedia.data.remote.dto

data class PondGrowthPredictionParamDto(
    val temperature: Float,
    val turbidity: Float,
    val dissolvedOxygen: Float,
    val pH: Float,
    val ammonia: Float,
    val nitrate: Float,
    val weight: Float
)