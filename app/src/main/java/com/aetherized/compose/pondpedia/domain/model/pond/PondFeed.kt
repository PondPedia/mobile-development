package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFeed(
    val name: String = "Default",
    val feedPercentage: Float = 7f,
    val proteinPercentage: Float = 42f,
    val lipidPercentage: Float = 25f,
    val carbohydratePercentage: Float = 20f,
    val othersPercentage: Float = 13f,
    val feedingFrequencyDaily: Int = 2,
) : Parcelable
