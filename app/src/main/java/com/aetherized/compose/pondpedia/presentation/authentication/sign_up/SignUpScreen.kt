package com.aetherized.compose.pondpedia.presentation.authentication.sign_up

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.authentication.sign_in.SignInState

@Composable
fun SignUpScreen(
    state: SignInState,
    onEmailPasswordSignInClick: () -> Unit,
    onEmailPasswordSignUpClick: (String, String) -> Unit
) {
    val context = LocalContext.current
    val email = remember { mutableStateOf(state.email) }
    val password = remember { mutableStateOf(state.password) }
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onEmailPasswordSignUpClick(email.value, password.value) }) {
                Text(text = "Sign up with Email/Password")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onEmailPasswordSignInClick) {
                Text(text = "Already have an Account")
            }
        }
    }
}