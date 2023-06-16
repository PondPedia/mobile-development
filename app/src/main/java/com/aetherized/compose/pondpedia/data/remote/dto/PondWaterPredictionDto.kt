package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.domain.model.pond.PondWaterPrediction

data class PondWaterPredictionDto(
    val temperature: Float?,
    val turbidity: Float?,
    val dissolvedOxygen: Float?,
    val pH: Float?,
    val ammonia: Float?,
    val nitrate: Float?,
) {
    fun toPondWater(): PondWaterPrediction {
        return PondWaterPrediction(
            temperature = temperature,
            turbidity = turbidity,
            dissolvedOxygen = dissolvedOxygen,
            pH = pH,
            ammonia = ammonia,
            nitrate = nitrate
        )
    }
}
