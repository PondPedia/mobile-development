package com.aetherized.compose.pondpedia.presentation.authentication.sign_up

import com.aetherized.compose.pondpedia.presentation.authentication.components.UserData

data class SignUpResult(
    val data: UserData?,
    val errorMessage: String?
)
