@file:OptIn(ExperimentalMaterial3Api::class)

package com.aetherized.compose.pondpedia.presentation.authentication.sign_in

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aetherized.compose.pondpedia.R
import com.aetherized.compose.pondpedia.presentation.authentication.components.SignInState
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme
import com.aetherized.compose.pondpedia.presentation.ui.theme.White

@Composable
fun SignInScreen(
    state: SignInState,
    onGoogleSignInClick: () -> Unit,
    onEmailPasswordSignInClick: (String, String) -> Unit,
    onGuestSignInClick: () -> Unit
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


    Image(
        painter = painterResource(R.drawable.underwater_light_blue),
        contentDescription = "Background Image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxHeight()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(80.dp))

                Image(
                    painter = painterResource(R.drawable.pondpedia_1),
                    contentDescription = "Brush",
                    modifier = Modifier
                        .size(200.dp)
                        .alpha(0.75f),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Spacer(modifier = Modifier.height(80.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(
                            text = stringResource(R.string.title_signin_page),
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(R.string.message_signin_page),
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Column {
                    TextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text("Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(.6f),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = White,
                            unfocusedContainerColor = White,
                            disabledContainerColor = White,
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = { Text("Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(.6f),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = White,
                            unfocusedContainerColor = White,
                            disabledContainerColor = White,
                        ),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.navi),
                            contentColor = Color.White
                        ),
                        onClick = { onEmailPasswordSignInClick(email.value, password.value) }) {
                        Text(text = stringResource(id = R.string.login), maxLines = 1)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.navi),
                                contentColor = Color.White
                            ),
                            onClick = onGuestSignInClick
                        ) {
                            Text(text = stringResource(id = R.string.login_guest), maxLines = 1)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.navi),
                                contentColor = Color.White
                            ),
                            onClick = onGoogleSignInClick
                        ) {
                            Text(text = stringResource(id = R.string.login_google), maxLines = 1)
                        }
                    }
                }


                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(id = R.string.copyright),
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun SignInScreenUI(
) {
    Image(
        painter = painterResource(R.drawable.underwater_light_blue),
        contentDescription = "Background Image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxHeight()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(80.dp))

                Image(
                    painter = painterResource(R.drawable.pondpedia_1),
                    contentDescription = "Brush",
                    modifier = Modifier
                        .size(200.dp)
                        .alpha(0.75f),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Spacer(modifier = Modifier.height(80.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(
                            text = stringResource(R.string.title_signin_page),
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(R.string.message_signin_page),
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Column {
                    TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(.6f),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = White,
                            unfocusedContainerColor = White,
                            disabledContainerColor = White,
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(.6f),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = White,
                            unfocusedContainerColor = White,
                            disabledContainerColor = White,
                        ),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.navi),
                            contentColor = Color.White
                        ),
                        onClick = { }) {
                        Text(text = stringResource(id = R.string.login))
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.navi),
                                contentColor = Color.White
                            ),
                            onClick = { }
                        ) {
                            Text(text = stringResource(id = R.string.login_guest), maxLines = 1)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.navi),
                                contentColor = Color.White
                            ),
                            onClick = { }
                        ) {
                            Text(text = stringResource(id = R.string.login_google), maxLines = 1)
                        }
                    }
                }


                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(id = R.string.copyright),
                    fontSize = 14.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    PondPediaCustomTheme {
        SignInScreenUI()
    }
}