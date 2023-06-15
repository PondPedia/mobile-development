package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFeed(
    val feedName: String = "Default",
    val feedPercentage: Float = 7f,
    val feedProteinPercentage: Float = 42f,
    val feedLipidPercentage: Float = 25f,
    val feedCarbohydratePercentage: Float = 20f,
    val feedOthersPercentage: Float = 13f,
    val feedFrequencyDaily: Int = 2,
) : Parcelable
