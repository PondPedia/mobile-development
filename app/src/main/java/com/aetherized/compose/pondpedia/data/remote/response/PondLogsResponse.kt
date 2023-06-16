package com.aetherized.compose.pondpedia.data.remote.response

import com.aetherized.compose.pondpedia.data.remote.dto.PondLogDto
import com.google.gson.annotations.SerializedName

data class PondLogsResponse (
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("listPondLogs")
    val data: List<PondLogDto>
)