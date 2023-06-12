package com.aetherized.compose.pondpedia.data.mapper

import com.aetherized.compose.pondpedia.data.local.entity.PondEntity
import com.aetherized.compose.pondpedia.domain.model.pond.Pond

fun PondEntity.toPond(): Pond {
    return Pond(
        pondName = pondName,
        pondLength = pondLength,
        pondWidth = pondWidth,
        pondDepth = pondDepth,
        pondImageUrl = pondImageUrl,
        pondFish = pondFish,
        pondFeed = pondFeed,
        pondWater = pondWater,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}
fun Pond.toPondEntity(): PondEntity {
    return PondEntity(
        pondName = pondName,
        pondLength = pondLength,
        pondWidth = pondWidth,
        pondDepth = pondDepth,
        pondImageUrl = pondImageUrl,
        pondFish = pondFish,
        pondFeed = pondFeed,
        pondWater = pondWater,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}