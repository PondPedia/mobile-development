package com.aetherized.compose.pondpedia.presentation.authentication.sign_up

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.cancellation.CancellationException
import com.aetherized.compose.pondpedia.presentation.authentication.components.UserData

class EmailPasswordSignUpClient {
    private val auth = Firebase.auth

    suspend fun signUpWithEmailAndPassword(email: String, password: String): SignUpResult {
        return try {
            val user = auth.createUserWithEmailAndPassword(email, password).await().user
            SignUpResult(
                data = user?.run {
                    UserData(
                        userId = uid,
                        username = displayName,
                        pictureUrl = photoUrl?.toString(),
                        userEmail = email
                    )
                },
                errorMessage = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            SignUpResult(
                data = null,
                errorMessage = e.message
            )
        }
    }
}

