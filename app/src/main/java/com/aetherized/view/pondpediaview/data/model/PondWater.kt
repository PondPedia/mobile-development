package com.aetherized.view.pondpediaview.data.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondWater(
    var temperature: Float?,
    var turbidity: Float?,
    var dissolvedOxygen: Float?,
    var pH: Float?,
    var ammonia: Float?,
    var nitrate: Float?,
) : Parcelable
