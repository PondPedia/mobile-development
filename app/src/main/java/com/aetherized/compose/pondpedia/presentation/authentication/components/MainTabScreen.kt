 package com.aetherized.compose.pondpedia.presentation.authentication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.ui.theme.Navi
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme
import com.aetherized.compose.pondpedia.presentation.ui.theme.White

 enum class Tab (val title: String) {
    TabA("A"),

    MainTab("Main"),
    SignInTab("Masuk"),
    SignUpTab("Daftar"),
}

@Composable
fun MainTabScreen() {
    var selectedTab by remember { mutableStateOf(Tab.TabA) }
    var tabIndex by remember { mutableStateOf(1) }

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth(),
            containerColor = Transparent,
        ) {
            Tab(
                text = { Text(Tab.SignInTab.title) },
                selected = selectedTab == Tab.SignInTab,
                onClick = {
                    selectedTab = Tab.SignInTab
                    tabIndex = 0
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Navi, shape = RoundedCornerShape(8.dp))
                    .border(width = 1.dp, color = Navi, shape = RoundedCornerShape(16.dp)),
                unselectedContentColor = White,
                selectedContentColor = White
            )
            Tab(
                text = { Text(Tab.SignUpTab.title) },
                selected = selectedTab == Tab.SignUpTab,
                onClick = {
                    selectedTab = Tab.SignUpTab
                    tabIndex = 2
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Navi, shape = RoundedCornerShape(8.dp))
                    .border(width = 1.dp, color = Navi, shape = RoundedCornerShape(16.dp)),
                unselectedContentColor = White,
                selectedContentColor = White
            )
        }
        when (selectedTab) {
            Tab.SignInTab -> Unit
            Tab.SignUpTab -> Unit
            else -> Unit
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabPreview() {
    PondPediaCustomTheme(darkTheme = true) {
        MainTabScreen()
    }
    
}