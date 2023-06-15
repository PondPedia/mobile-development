package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.domain.model.pond.PondFish

data class PondFishDto(
    val fId: Int? = 0,
    val fishId: String = "fish-id",
    val fishCommonName: String = "African Catfish",
    val fishScientificName: String = "Clarias gariepinus",
    val fishAmount: Int,
    val fishTargetWeight: Float,
    val fishCurrentWeight: Float,
    val fishCurrentLength: Float,
) {
    fun toPondFish(): PondFish {
        return PondFish(
            fishId = fishId,
            fishCommonName = fishCommonName,
            fishScientificName = fishScientificName,
            fishAmount = fishAmount,
            fishTargetWeight = fishTargetWeight,
            fishCurrentWeight = fishCurrentWeight,
            fishCurrentLength = fishCurrentLength
        )
    }
}
