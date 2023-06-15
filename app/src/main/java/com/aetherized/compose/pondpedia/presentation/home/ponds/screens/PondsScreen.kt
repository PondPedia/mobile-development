package com.aetherized.compose.pondpedia.presentation.home.ponds.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme

private val selectedNavItem = BottomNavItem.Ponds

@Preview
@Composable
fun PondScreenPreview() {
    PondPediaCustomTheme(darkTheme = true) {
        PondsScreenA()
    }
}
@Composable
fun PondsScreenA() {
    Column {
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun PondsScreenB() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun PondsScreenC() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}

@Composable
fun PondsScreenD() {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = selectedNavItem.title)
    }
}