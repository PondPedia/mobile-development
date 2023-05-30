package com.aetherized.view.pondpediaview.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFish(
    var fid: Int,
    var name: String? = null,
    var amount: Float? = null,
    var weight: Float? = null,
) : Parcelable
