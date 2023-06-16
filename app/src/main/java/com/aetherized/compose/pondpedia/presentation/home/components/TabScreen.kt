package com.aetherized.compose.pondpedia.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aetherized.compose.pondpedia.presentation.authentication.components.UserData
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenA
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenB
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenC
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenD
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenA
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenB
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenC
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenD
import com.aetherized.compose.pondpedia.presentation.home.history.screens.HistoryScreenA
import com.aetherized.compose.pondpedia.presentation.home.history.screens.HistoryScreenB
import com.aetherized.compose.pondpedia.presentation.home.history.screens.HistoryScreenC
import com.aetherized.compose.pondpedia.presentation.home.history.screens.HistoryScreenD
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenA
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenB
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenC
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenD
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondState
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondViewModel
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenA
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenB
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenC
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenD

enum class Tab (val title: String) {
    TabA("A"),
    TabB("B"),
    TabC("C"),
    TabD("D"),

    PondsTabA("Lele"),
    PondsTabB("Nila"),
    PondsTabC("Gurame"),
    PondsTabD("Mas"),

    HistoryTabA("Semua"),
    HistoryTabB("Kolam"),
    HistoryTabC("Pedia"),
    HistoryTabD("Lainnya"),

    CreateTabA("Kolam"),
    CreateTabB("Ikan"),
    CreateTabC("Pakan"),
    CreateTabD("Air"),

    ExploreTabA("Ikan"),
    ExploreTabB("Pakan"),
    ExploreTabC("Penyakit"),
    ExploreTabD("Air"),

    MoreTabA("Profil"),
    MoreTabB("Pengaturan"),
    MoreTabC("Tentang"),
    MoreTabD("Bantuan"),
}

@Composable
fun TabScreen(
    navItem: BottomNavItem,
    userData: UserData?,
    pondState: PondState,
    pondViewModel: PondViewModel,
    onSignOut: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(Tab.PondsTabA) }
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = when (navItem) {
        BottomNavItem.Ponds -> {
            listOf(
                Tab.PondsTabA,
                Tab.PondsTabB,
                Tab.PondsTabC,
                Tab.PondsTabD,
            )
        }
        BottomNavItem.History -> {
            listOf(
                Tab.HistoryTabA,
                Tab.HistoryTabB,
                Tab.HistoryTabC,
                Tab.HistoryTabD,
            )
        }
        BottomNavItem.Create -> {
            listOf(
                Tab.CreateTabA,
                Tab.CreateTabB,
                Tab.CreateTabC,
                Tab.CreateTabD,
            )
        }
        BottomNavItem.Explore -> {
            listOf(
                Tab.ExploreTabA,
                Tab.ExploreTabB,
                Tab.ExploreTabC,
                Tab.ExploreTabD,
            )
        }
        BottomNavItem.More -> {
             listOf(
                Tab.MoreTabA,
                Tab.MoreTabB,
                Tab.MoreTabC,
                Tab.MoreTabD,
            )
        }
    }

    LaunchedEffect(navItem) {
        tabIndex = 0
        selectedTab = when (navItem) {
            BottomNavItem.Ponds -> {
                Tab.PondsTabA
            }

            BottomNavItem.History -> {
                Tab.HistoryTabA
            }

            BottomNavItem.Create -> {
                Tab.CreateTabA
            }

            BottomNavItem.Explore -> {
                Tab.ExploreTabA
            }

            BottomNavItem.More -> {
                Tab.MoreTabA
            }
        }
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = { Text(text = tab.title, fontSize = 12.sp, maxLines = 1) },
                    selected = selectedTab == tab,
                    onClick = {
                        selectedTab = tab
                        tabIndex = index
                    },
                    selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
        when (selectedTab) {
            Tab.PondsTabA -> PondsScreenA(pondState = pondState, pondViewModel = pondViewModel)
            Tab.PondsTabB -> PondsScreenB()
            Tab.PondsTabC -> PondsScreenC()
            Tab.PondsTabD -> PondsScreenD()
            Tab.HistoryTabA -> HistoryScreenA()
            Tab.HistoryTabB -> HistoryScreenB()
            Tab.HistoryTabC -> HistoryScreenC()
            Tab.HistoryTabD -> HistoryScreenD()
            Tab.CreateTabA -> CreateScreenA(pondViewModel)
            Tab.CreateTabB -> CreateScreenB(pondViewModel)
            Tab.CreateTabC -> CreateScreenC(pondViewModel)
            Tab.CreateTabD -> CreateScreenD(pondViewModel)
            Tab.ExploreTabA -> ExploreScreenA()
            Tab.ExploreTabB -> ExploreScreenB()
            Tab.ExploreTabC -> ExploreScreenC()
            Tab.ExploreTabD -> ExploreScreenD()
            Tab.MoreTabA -> MoreScreenA(userData = userData, onSignOut = onSignOut)
            Tab.MoreTabB -> MoreScreenB()
            Tab.MoreTabC -> MoreScreenC()
            Tab.MoreTabD -> MoreScreenD()
            else -> PondsScreenB()
        }
    }
}

@Preview
@Composable
fun TabPreview() {
//    PondPediaCustomTheme {
//        TabScreen(navItem = BottomNavItem.Ponds)
//    }
//    TabScreen(navItem = BottomNavItem.Ponds, userData = null, onSignOut = {})
    
}

