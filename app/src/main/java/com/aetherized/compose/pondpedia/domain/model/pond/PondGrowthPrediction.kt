package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondGrowthPrediction(
    val growthDate: String? = null,
    val growthLength: Float? = null,
    val growthWeight: Float? = null,
): Parcelable
