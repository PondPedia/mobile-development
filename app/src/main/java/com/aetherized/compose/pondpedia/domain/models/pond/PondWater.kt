package com.aetherized.compose.pondpedia.domain.models.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondWater(
    val temperature: Float? = null,
    val turbidity: Float? = null,
    val dissolvedOxygen: Float? = null,
    val pH: Float? = null,
    val ammonia: Float? = null,
    val nitrate: Float? = null,
) : Parcelable
