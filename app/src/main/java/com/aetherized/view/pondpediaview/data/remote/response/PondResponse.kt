package com.aetherized.view.pondpediaview.data.remote.response

import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.google.gson.annotations.SerializedName

data class PondResponse (
    @field:SerializedName("totalResults")
    val totalResults: Int,

    @field:SerializedName("ponds")
    val ponds: List<PondEntity>,

    @field:SerializedName("status")
    val status: String,
)
