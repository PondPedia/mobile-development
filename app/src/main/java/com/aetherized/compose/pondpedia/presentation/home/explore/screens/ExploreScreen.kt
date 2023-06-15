package com.aetherized.compose.pondpedia.presentation.home.explore.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.components.TabScreen

private val selectedNavItem = BottomNavItem.Explore

@Composable
fun ExploreScreenA() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun ExploreScreenB() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun ExploreScreenC() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun ExploreScreenD() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}