package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.domain.model.pond.PondFeed

data class PondFeedDto(
    val feedName: String = "Default",
    val feedPercentage: Float = 7f,
    val feedProteinPercentage: Float = 42f,
    val feedLipidPercentage: Float = 25f,
    val feedCarbohydratePercentage: Float = 20f,
    val feedOthersPercentage: Float = 13f,
    val feedFrequencyDaily: Int = 2,
) {
    fun toPondFeed(): PondFeed {
        return PondFeed(
            feedName = feedName,
            feedPercentage = feedPercentage,
            feedProteinPercentage = feedProteinPercentage,
            feedLipidPercentage = feedLipidPercentage,
            feedCarbohydratePercentage = feedCarbohydratePercentage,
            feedOthersPercentage = feedOthersPercentage,
            feedFrequencyDaily = feedFrequencyDaily
        )
    }
}
