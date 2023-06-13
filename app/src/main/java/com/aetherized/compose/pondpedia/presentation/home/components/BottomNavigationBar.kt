package com.aetherized.compose.pondpedia.presentation.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.RotateRight
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit
) {
    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                selected = item == selectedItem,
                onClick = { onItemSelected(item) },
                label = { Text(text = item.title) },
                alwaysShowLabel = true
            )
        }
    }
}

enum class BottomNavItem(val title: String, val icon: ImageVector) {
    Ponds("Ponds", Icons.Outlined.Analytics),
    Updates("Updates", Icons.Outlined.RotateRight),
    Create("Create", Icons.Outlined.Add),
    Explore("Explore", Icons.Outlined.Explore),
    More("More", Icons.Outlined.Menu)
}