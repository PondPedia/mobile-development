package com.aetherized.compose.pondpedia.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aetherized.compose.pondpedia.presentation.authentication.MainScreen
import com.aetherized.compose.pondpedia.presentation.authentication.sign_in.EmailPasswordAuthClient
import com.aetherized.compose.pondpedia.presentation.authentication.sign_in.GoogleAuthUiClient
import com.aetherized.compose.pondpedia.presentation.authentication.sign_in.SignInScreen
import com.aetherized.compose.pondpedia.presentation.authentication.sign_in.SignInViewModel
import com.aetherized.compose.pondpedia.presentation.authentication.sign_up.EmailPasswordSignUpClient
import com.aetherized.compose.pondpedia.presentation.authentication.sign_up.SignUpScreen
import com.aetherized.compose.pondpedia.presentation.home.more.screens.ProfileScreen
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }
    private val emailPasswordAuthClient by lazy {
        EmailPasswordAuthClient()
    }
    private val emailPasswordSignUpClient by lazy {
        EmailPasswordSignUpClient()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PondPediaCustomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PondPediaAuthentication()
                }
            }
        }
    }

    @Composable
    fun PondPediaAuthentication() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                MainScreen(
                    onSignInClick = {
                        Toast.makeText(
                            this@MainActivity,
                            "Sign In",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate("sign_in")
                    },
                    onSignUpClick = {

                        Toast.makeText(
                            this@MainActivity,
                            "Sign Up",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate("sign_up")
                    },
                )
            }
            composable("sign_in") {
                val viewModel = viewModel<SignInViewModel>(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
                                @Suppress("UNCHECKED_CAST")
                                return SignInViewModel(emailPasswordAuthClient, emailPasswordSignUpClient) as T
                            }
                            throw IllegalArgumentException("Unknown ViewModel class")
                        }
                    }
                )

                val state by viewModel.state.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = Unit) {
                    if(googleAuthUiClient.getSignedInUser() != null) {
                        navController.navigate("profile")
                    }
                }

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        if(result.resultCode == RESULT_OK) {
                            lifecycleScope.launch {
                                val signInResult = googleAuthUiClient.signInWithGoogle(
                                    intent = result.data ?: return@launch
                                )
                                viewModel.onSignInResult(signInResult)
                            }
                        }
                    }
                )

                LaunchedEffect(key1 = state.isSignInSuccessful) {
                    if(state.isSignInSuccessful) {
                        Toast.makeText(
                            this@MainActivity,
                            "Sign in successful",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate("profile")
                        viewModel.resetState()
                    }
                }

                SignInScreen(
                    state = state,
                    onGoogleSignInClick = {
                        lifecycleScope.launch {
                            val signInIntentSender = googleAuthUiClient.signIn()
                            launcher.launch(
                                IntentSenderRequest.Builder(
                                    signInIntentSender ?: return@launch
                                ).build()
                            )
                        }
                    },
                    onEmailPasswordSignInClick = { email, password ->
                        viewModel.onEmailPasswordSignIn(email, password)
                    },

                    onGuestSignInClick = {
                        navController.navigate("hore")
                    }
                )
            }
            composable("sign_up") {
                val viewModel = viewModel<SignInViewModel>(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
                                return SignInViewModel(emailPasswordAuthClient, emailPasswordSignUpClient) as T
                            }
                            throw IllegalArgumentException("Unknown ViewModel class")
                        }
                    }
                )

                val state by viewModel.state.collectAsStateWithLifecycle()
                SignUpScreen(
                    state = state,

                    onEmailPasswordSignInClick = {
                        navController.navigate("sign_in")
                    },
                    onEmailPasswordSignUpClick = { email, password ->
                        viewModel.onEmailPasswordSignUp(email, password)
                    }
                )
            }
            composable("profile") {
                ProfileScreen(
                    userData = googleAuthUiClient.getSignedInUser(),
                    onSignOut = {
                        lifecycleScope.launch {
                            googleAuthUiClient.signOut()
                            Toast.makeText(
                                this@MainActivity,
                                "Signed out",
                                Toast.LENGTH_LONG
                            ).show()

                            navController.popBackStack()
                        }
                    }
                )
            }
//            composable("home") {
//                HomeScreen()
//            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PondPediaCustomTheme {
            MainScreen(
                onSignInClick = {
                    Toast.makeText(
                        this@MainActivity,
                        "Sign In",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onSignUpClick = {
                    Toast.makeText(
                        this@MainActivity,
                        "Sign In",
                        Toast.LENGTH_SHORT
                    ).show()
                },
            )

        }
    }
}
