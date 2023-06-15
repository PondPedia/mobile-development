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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aetherized.compose.pondpedia.core.PondPediaApp
import com.aetherized.compose.pondpedia.presentation.authentication.MainScreen
import com.aetherized.compose.pondpedia.presentation.authentication.components.EmailPasswordAuthClient
import com.aetherized.compose.pondpedia.presentation.authentication.components.GoogleAuthUiClient
import com.aetherized.compose.pondpedia.presentation.authentication.components.SignInViewModel
import com.aetherized.compose.pondpedia.presentation.authentication.sign_in.SignInScreen
import com.aetherized.compose.pondpedia.presentation.authentication.sign_up.EmailPasswordSignUpClient
import com.aetherized.compose.pondpedia.presentation.authentication.sign_up.SignUpScreen
import com.aetherized.compose.pondpedia.presentation.home.HomeScreen
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondLogViewModel
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme
import com.google.android.gms.auth.api.identity.Identity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {
    private val dataStore by lazy { (application as PondPediaApp).pondPediaDataStore }
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

    private lateinit var signInViewModel: SignInViewModel
    private lateinit var pondLogViewModel: PondLogViewModel
    @Composable
    fun setupViewModels() {
        signInViewModel = viewModel(
            factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return SignInViewModel(emailPasswordAuthClient, emailPasswordSignUpClient, dataStore) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PondPediaCustomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    setupViewModels()
                    val navController = rememberNavController()
                    val state by signInViewModel.state.collectAsStateWithLifecycle()

                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(
                                onSignInClick = {
                                    navController.navigate("sign_in")
                                },
                                onSignUpClick = {
                                    navController.navigate("sign_up")
                                },
                            )
                        }
                        composable("sign_in") {
                            LaunchedEffect(key1 = Unit) {
                                if (googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate("home")
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if (result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithGoogle(
                                                intent = result.data ?: return@launch
                                            )
                                            signInViewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if (state.isSignInSuccessful) {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    val userData = googleAuthUiClient.getSignedInUser()

                                    navController.navigate("home")
                                    signInViewModel.saveLogin(userData)
                                    signInViewModel.resetState()
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
                                    signInViewModel.onEmailPasswordSignIn(email, password)
                                },

                                onGuestSignInClick = {
                                    navController.navigate("home")
                                }
                            )
                        }
                        composable("sign_up") {
                            SignUpScreen(
                                state = state,

                                onEmailPasswordSignInClick = {
                                    navController.navigate("sign_in")
                                },
                                onEmailPasswordSignUpClick = { email, password ->
                                    signInViewModel.onEmailPasswordSignUp(email, password)
                                }
                            )
                        }
                        composable("home") {
                            HomeScreen(
                                userData = googleAuthUiClient.getSignedInUser(),
                                onSignOut = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()

                                        navController.popBackStack()
                                    }
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}

