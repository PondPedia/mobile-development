package com.aetherized.compose.pondpedia.presentation.authentication.sign_in

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.cancellation.CancellationException

class EmailPasswordAuthClient {
    private val auth = Firebase.auth

    suspend fun signInWithEmailAndPassword(email: String, password: String): SignInResult {
        return try {
            val user = auth.signInWithEmailAndPassword(email, password).await().user
            SignInResult(
                data = user?.run {
                    UserData(
                        userId = uid,
                        username = displayName,
                        profilePictureUrl = photoUrl?.toString()
                    )
                },
                errorMessage = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            SignInResult(
                data = null,
                errorMessage = e.message
            )
        }
    }
}
