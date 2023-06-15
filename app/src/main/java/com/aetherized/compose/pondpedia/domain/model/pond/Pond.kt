package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.Instant

@Parcelize
data class Pond(
    val pId: Int? = null,

    val pondName: String,

    val pondLength: Float,

    val pondWidth: Float,

    val pondDepth: Float,

    val pondImageUrl: String? = null,

    val pondFish: PondFish,

    val pondFeed: PondFeed,

    val pondWater: PondWater,

    val createdAt: String? = Instant.now().toString(),

    val updatedAt: String? = Instant.now().toString(),
) : Parcelable

val dummyPondA = Pond(
    1,
    "Pond Dummy A",
    10f,
    10f,
    2f,
    "www.example.com/images/1",
    PondFish(
        1,
    ),
    PondFeed(),
    PondWater(),
    createdAt = null,
    updatedAt = null,
)