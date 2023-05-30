package com.aetherized.view.pondpediaview.data.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFeed(
    var name: String = "Custom Default",
    var feedPercentage: Float = 7f,
    var proteintPercentage: Float = 42f,
    var lipidPercentage: Float = 25f,
    var carbohydratePercentage: Float = 20f,
    var othersPercentage: Float = 13f,
    var feedingFrequencyDaily: Int = 2,
) : Parcelable
