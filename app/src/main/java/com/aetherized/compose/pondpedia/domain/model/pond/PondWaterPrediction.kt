package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondWaterPrediction(
    val temperature: Float? = null,
    val turbidity: Float? = null,
    val dissolvedOxygen: Float? = null,
    val pH: Float? = null,
    val ammonia: Float? = null,
    val nitrate: Float? = null,
): Parcelable
