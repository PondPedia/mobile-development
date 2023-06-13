package com.aetherized.compose.pondpedia.presentation.home.create.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.components.TabScreen

private val selectedNavItem = BottomNavItem.Create

@Composable
fun CreateScreenA() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun CreateScreenB() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun CreateScreenC() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun CreateScreenD() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}