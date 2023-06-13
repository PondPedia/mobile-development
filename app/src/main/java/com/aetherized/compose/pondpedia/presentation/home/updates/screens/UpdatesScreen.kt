package com.aetherized.compose.pondpedia.presentation.home.updates.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.components.TabScreen

private val selectedNavItem = BottomNavItem.Updates

@Composable
fun UpdatesScreenA() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun UpdatesScreenB() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun UpdatesScreenC() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun UpdatesScreenD() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}