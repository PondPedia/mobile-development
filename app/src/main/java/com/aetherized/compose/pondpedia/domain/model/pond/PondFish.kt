package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFish(
    val fId: Int,
    val name: String? = "African Catfish",
    val scientificName: String? = "Clarias gariepinus",
    val amount: Float? = null,
    val targetWeight: Float? = null,
    val currentWeight: Float? = null,
    val currentLength: Float? = null,
) : Parcelable
