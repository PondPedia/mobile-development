package com.aetherized.compose.pondpedia.presentation.components.authentication.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val emailPasswordAuthClient: EmailPasswordAuthClient
): ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResult) {
        _state.update { it.copy(
            isSignInSuccessful = result.data != null,
            signInError = result.errorMessage
        ) }
    }
    fun onEmailPasswordSignIn(email: String, password: String) {
        viewModelScope.launch {
            val signInResult = emailPasswordAuthClient.signInWithEmailAndPassword(email, password)
            _state.update { it.copy(
                isSignInSuccessful = signInResult.data != null,
                signInError = signInResult.errorMessage
            ) }
        }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}