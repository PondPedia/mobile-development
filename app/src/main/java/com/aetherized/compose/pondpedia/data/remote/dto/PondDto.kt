package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.PondGrowthPrediction
import com.aetherized.compose.pondpedia.domain.model.pond.PondWaterPrediction
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

data class PondDto (
    val pondName: String,

    val pondLength: Float,

    val pondWidth: Float,

    val pondDepth: Float,

    val pondImageUrl: String? = null,

    val pondFish: PondFishDto,

    val pondFeed: PondFeedDto,

    val pondWater: PondWaterDto,

    val pondWaterPrediction: PondWaterPredictionDto,

    val pondGrowthPrediction: PondGrowthPredictionDto,

    val createdAt: String = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()),

    val updatedAt: String = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()),

    val pondId: String = "pond-${UUID.randomUUID()}",
) {
    fun toPond(): Pond {
        return Pond(
            pondName = pondName,
            pondLength = pondLength,
            pondWidth = pondWidth,
            pondDepth = pondDepth,
            pondImageUrl = pondImageUrl,
            pondFish = pondFish.toPondFish(),
            pondFeed = pondFeed.toPondFeed(),
            pondWater = pondWater.toPondWater(),
            pondWaterPrediction = PondWaterPrediction(),
            pondGrowthPrediction = PondGrowthPrediction(),
            createdAt = createdAt,
            updatedAt = updatedAt,
            pondId = pondId,
        )
    }
}