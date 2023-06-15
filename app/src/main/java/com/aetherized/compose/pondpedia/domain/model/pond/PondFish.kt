package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFish(
    val fishId: String = "fish-id",
    val fishCommonName: String = "African Catfish",
    val fishScientificName: String = "Clarias gariepinus",
    val fishAmount: Int,
    val fishTargetWeight: Float,
    val fishCurrentWeight: Float,
    val fishCurrentLength: Float,
) : Parcelable
