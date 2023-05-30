package com.dicoding.aetherized.aetherizedstoryappview.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse<T>(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("loginResult")
    val data: T?
)
