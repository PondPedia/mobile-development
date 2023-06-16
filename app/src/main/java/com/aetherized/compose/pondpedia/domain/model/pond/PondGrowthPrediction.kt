package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondGrowthPrediction(
    val growthLength: Float? = null,
    val growthFeed: Float? = null,
    val growthDays: Float? = null,
): Parcelable
