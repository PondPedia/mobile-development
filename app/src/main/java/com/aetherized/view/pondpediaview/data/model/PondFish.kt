package com.aetherized.view.pondpediaview.data.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFish(
    var fid: Int,
    var name: String?,
    var amount: Float?,
    var weight: Float?,
) : Parcelable
