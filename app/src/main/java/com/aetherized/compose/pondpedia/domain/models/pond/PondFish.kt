package com.aetherized.compose.pondpedia.domain.models.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondFish(
    val fId: Int,
    val name: String? = null,
    val amount: Float? = null,
    val targetWeight: Float? = null,
    val currentWeight: Float? = null,
    val currentLength: Float? = null,
) : Parcelable
