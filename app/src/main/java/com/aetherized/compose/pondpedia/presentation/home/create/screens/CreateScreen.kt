package com.aetherized.compose.pondpedia.presentation.home.create.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.components.TabScreen
import com.google.android.play.integrity.internal.m

private val selectedNavItem = BottomNavItem.Create

@Composable
fun CreateScreenA() {
    var pondName = remember { mutableStateOf("") }
    var pondLength = remember { mutableStateOf(0f) }
    var pondWidth = remember { mutableStateOf(0f) }
    var pondDepth = remember { mutableStateOf(0f) }
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