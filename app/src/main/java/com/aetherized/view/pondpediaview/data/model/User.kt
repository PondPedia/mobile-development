package com.aetherized.view.pondpediaview.data.model

data class User(
    val name: String,
    val email: String,
    val password: String,
    val isLogin: Boolean = false
)
