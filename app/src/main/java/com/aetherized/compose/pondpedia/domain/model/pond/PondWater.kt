package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondWater(
    var temperature: Float,
    var turbidity: Float,
    var dissolvedOxygen: Float,
    var pH: Float,
    var ammonia: Float,
    var nitrate: Float,
): Parcelable
