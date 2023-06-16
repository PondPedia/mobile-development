package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFeed(
    var feedName: String = "Default",
    var feedPercentage: Float = 7f,
    var feedProteinPercentage: Float = 42f,
    var feedLipidPercentage: Float = 25f,
    var feedCarbohydratePercentage: Float = 20f,
    var feedOthersPercentage: Float = 13f,
    var feedFrequencyDaily: Int = 2,
) : Parcelable
