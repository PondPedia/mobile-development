package com.aetherized.compose.pondpedia.presentation.authentication.sign_in

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
    val isSignUpSuccessful: Boolean = false,
    val signUpError: String? = null,
    val email: String = "",
    val password: String = "",
)
