package com.aetherized.compose.pondpedia.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavigationBar
import com.aetherized.compose.pondpedia.presentation.home.components.TabScreen
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme


val bottomNavItems = listOf(
    BottomNavItem.Ponds,
    BottomNavItem.Updates,
    BottomNavItem.Create,
    BottomNavItem.Explore,
    BottomNavItem.More
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    PondPediaCustomTheme(darkTheme = true) {
        var selectedNavItem by remember { mutableStateOf(BottomNavItem.Ponds) }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = selectedNavItem.title)
                    },
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    items = bottomNavItems,
                    selectedItem = selectedNavItem,
                    onItemSelected = { navItem ->
                        selectedNavItem = navItem
                    }
                )
            },
        ) { innerPadding ->
            Box(
                Modifier.padding(innerPadding)
            ) {
                TabScreen(navItem = selectedNavItem)
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    HomeScreen()
}
