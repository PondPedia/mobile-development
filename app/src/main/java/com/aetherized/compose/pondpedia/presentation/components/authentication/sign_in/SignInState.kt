package com.aetherized.compose.pondpedia.presentation.components.authentication.sign_in

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
    val email: String = "",
    val password: String = "",
)
