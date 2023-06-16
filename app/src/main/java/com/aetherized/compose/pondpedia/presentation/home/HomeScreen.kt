package com.aetherized.compose.pondpedia.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aetherized.compose.pondpedia.presentation.authentication.components.UserData
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavigationBar
import com.aetherized.compose.pondpedia.presentation.home.components.TabScreen
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondState
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondViewModel
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme
import kotlinx.coroutines.flow.collectLatest


val bottomNavItems = listOf(
    BottomNavItem.Ponds,
    BottomNavItem.History,
    BottomNavItem.Create,
    BottomNavItem.Explore,
    BottomNavItem.More
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    userData: UserData?,
    pondState: PondState,
    scaffoldState: ScaffoldState,
    pondViewModel: PondViewModel,
    onSignOut: () -> Unit
) {
    PondPediaCustomTheme(darkTheme = true) {
        LaunchedEffect(key1 = true) {
            pondViewModel.eventFlow.collectLatest { event ->
                when(event) {
                    is PondViewModel.UIEvent.ShowSnackBar -> {
                        scaffoldState.snackbarHostState.showSnackbar(
                                message = event.message
                        )
                    }
                }
            }
        }

        var selectedNavItem by remember { mutableStateOf(BottomNavItem.Ponds) }


        Scaffold(
            snackbarHost = { scaffoldState.snackbarHostState },
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
                Modifier
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                TabScreen(
                    navItem = selectedNavItem,
                    userData = userData,
                    pondState= pondState,
                    pondViewModel = pondViewModel,
                    onSignOut = onSignOut
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PondPediaCustomTheme(dynamicColor = false) {
    }
}
