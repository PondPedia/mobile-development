package com.aetherized.compose.pondpedia.data.remote.response

import com.aetherized.compose.pondpedia.data.remote.dto.UserDataDto
import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("userData")
    val userData: List<UserDataDto>
)