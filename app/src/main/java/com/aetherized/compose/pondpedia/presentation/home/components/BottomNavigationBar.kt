package com.aetherized.compose.pondpedia.presentation.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.RotateRight
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = item == selectedItem,
                onClick = { onItemSelected(item) }
            )
        }
    }

//    BottomNavigation {
//        items.forEach { item ->
//            BottomNavigationItem(
//                icon = { Icon(item.icon, contentDescription = item.title) },
//                selected = item == selectedItem,
//                onClick = { onItemSelected(item) },
//                label = { Text(text = item.title) },
//                alwaysShowLabel = false
//            )
//        }
//    }
}


enum class BottomNavItem(val title: String, val icon: ImageVector) {
    Ponds("Ponds", Icons.Outlined.Analytics),
    History("History", Icons.Outlined.RotateRight),
    Create("Create", Icons.Outlined.Add),
    Explore("Explore", Icons.Outlined.Explore),
    More("More", Icons.Outlined.Menu)
}

val bottomNavItems = listOf(
    BottomNavItem.Ponds,
    BottomNavItem.History,
    BottomNavItem.Create,
    BottomNavItem.Explore,
    BottomNavItem.More
)


@Preview
@Composable
fun BottomNavigationPreview() {
    PondPediaCustomTheme(darkTheme = true) {
        var selectedNavItem by remember { mutableStateOf(BottomNavItem.History) }

        BottomNavigationBar(
            items = com.aetherized.compose.pondpedia.presentation.home.bottomNavItems,
            selectedItem = selectedNavItem,
            onItemSelected = { navItem ->
                selectedNavItem = navItem
            }
        )
    }
}

