package com.aetherized.compose.pondpedia.presentation.authentication

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aetherized.compose.pondpedia.R


@Composable
fun MainScreen(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Image(
        painter = painterResource(R.drawable.underwater_light_blue),
        contentDescription = "Background Image",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.fillMaxHeight()
    )
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
            Spacer(modifier = Modifier.height(100.dp))

            Image(
                painter = painterResource(R.drawable.brush),
                contentDescription = "Brush",
                modifier = Modifier
                    .size(200.dp)
                    .alpha(0.75f),
                colorFilter = ColorFilter.tint(Color.White)
            )

            Spacer(modifier = Modifier.height(100.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = stringResource(R.string.title_welcome_page),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = stringResource(R.string.message_welcome_page),
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
            }



            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onSignInClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.navi), contentColor = Color.White)
                ) {
                    Text(text = stringResource(id = R.string.signin))
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = onSignUpClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.navi), contentColor = Color.White)
                ) {
                    Text(text = stringResource(id = R.string.signup))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(R.drawable.underwater_bubble), // Replace with your bubble drawable
                contentDescription = "Bubble",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
                    .offset(y = (-75).dp)
                    .alpha(0.75f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Copyright", // Replace with your copyright string resource
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}
