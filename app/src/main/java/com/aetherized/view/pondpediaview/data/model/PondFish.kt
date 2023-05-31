package com.aetherized.view.pondpediaview.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFish(
    var fid: Int,
    var name: String? = null,
    var amount: Float? = null,
    var harvestWeight: Float? = null,
    var currentWeight: Float? = null,
    var currentLength: Float? = null,
) : Parcelable
