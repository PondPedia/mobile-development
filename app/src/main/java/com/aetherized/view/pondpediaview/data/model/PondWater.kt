package com.aetherized.view.pondpediaview.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondWater(
    var temperature: Float? = null,
    var turbidity: Float? = null,
    var dissolvedOxygen: Float? = null,
    var pH: Float? = null,
    var ammonia: Float? = null,
    var nitrate: Float? = null,
) : Parcelable
