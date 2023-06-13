package com.aetherized.compose.pondpedia.presentation.home.more.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aetherized.compose.pondpedia.presentation.authentication.sign_in.UserData
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.components.TabScreen

private val selectedNavItem = BottomNavItem.More
@Composable
fun ProfileScreen(
    userData: UserData?,
    onSignOut: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(userData?.profilePictureUrl != null) {
            AsyncImage(
                model = userData.profilePictureUrl,
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        if(userData?.username != null) {
            Text(
                text = userData.username,
                textAlign = TextAlign.Center,
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Button(onClick = onSignOut) {
            Text(text = "Sign out")
        }
    }
}

@Composable
fun MoreScreenA() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}
@Composable
fun MoreScreenB() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun MoreScreenC() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun MoreScreenD() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}