package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondWater(
    val temperature: Float,
    val turbidity: Float,
    val dissolvedOxygen: Float,
    val pH: Float,
    val ammonia: Float,
    val nitrate: Float,
): Parcelable
