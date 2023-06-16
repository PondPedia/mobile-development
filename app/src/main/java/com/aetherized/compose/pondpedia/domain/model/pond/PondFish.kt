package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFish(
    var fishId: String = "fish-id",
    var fishCommonName: String = "African Catfish",
    var fishScientificName: String = "Clarias gariepinus",
    val fishAmount: Int,
    var fishTargetWeight: Float,
    var fishCurrentWeight: Float,
    var fishCurrentLength: Float,
) : Parcelable
