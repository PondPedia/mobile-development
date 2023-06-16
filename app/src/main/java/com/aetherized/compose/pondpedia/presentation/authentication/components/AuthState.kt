package com.aetherized.compose.pondpedia.presentation.authentication.components

data class AuthState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
    val isSignUpSuccessful: Boolean = false,
    val signUpError: String? = null,
    val email: String = "",
    val password: String = "",
)
