package com.aetherized.compose.pondpedia.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenA
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenB
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenC
import com.aetherized.compose.pondpedia.presentation.home.create.screens.CreateScreenD
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenA
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenB
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenC
import com.aetherized.compose.pondpedia.presentation.home.explore.screens.ExploreScreenD
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenA
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenB
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenC
import com.aetherized.compose.pondpedia.presentation.home.more.screens.MoreScreenD
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenA
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenB
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenC
import com.aetherized.compose.pondpedia.presentation.home.ponds.screens.PondsScreenD
import com.aetherized.compose.pondpedia.presentation.home.updates.screens.UpdatesScreenA
import com.aetherized.compose.pondpedia.presentation.home.updates.screens.UpdatesScreenB
import com.aetherized.compose.pondpedia.presentation.home.updates.screens.UpdatesScreenC
import com.aetherized.compose.pondpedia.presentation.home.updates.screens.UpdatesScreenD
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme

enum class Tab (val title: String) {
    TabA("A"),
    TabB("B"),
    TabC("C"),
    TabD("D"),

    PondsTabA("Lele"),
    PondsTabB("Nila"),
    PondsTabC("Gurame"),
    PondsTabD("Mas"),

    UpdatesTabA("Semua"),
    UpdatesTabB("Kolam"),
    UpdatesTabC("Pedia"),
    UpdatesTabD("Lainnya"),

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
fun TabScreen(navItem: BottomNavItem) {
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
        BottomNavItem.Updates -> {
            listOf(
                Tab.UpdatesTabA,
                Tab.UpdatesTabB,
                Tab.UpdatesTabC,
                Tab.UpdatesTabD,
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

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = { Text(tab.title) },
                    selected = selectedTab == tab,
                    onClick = {
                        selectedTab = tab
                        tabIndex = index
                    }
                )
            }
        }
        when (selectedTab) {
            Tab.PondsTabA -> PondsScreenA()
            Tab.PondsTabB -> PondsScreenB()
            Tab.PondsTabC -> PondsScreenC()
            Tab.PondsTabD -> PondsScreenD()
            Tab.UpdatesTabA -> UpdatesScreenA()
            Tab.UpdatesTabB -> UpdatesScreenB()
            Tab.UpdatesTabC -> UpdatesScreenC()
            Tab.UpdatesTabD -> UpdatesScreenD()
            Tab.CreateTabA -> CreateScreenA()
            Tab.CreateTabB -> CreateScreenB()
            Tab.CreateTabC -> CreateScreenC()
            Tab.CreateTabD -> CreateScreenD()
            Tab.ExploreTabA -> ExploreScreenA()
            Tab.ExploreTabB -> ExploreScreenB()
            Tab.ExploreTabC -> ExploreScreenC()
            Tab.ExploreTabD -> ExploreScreenD()
            Tab.MoreTabA -> MoreScreenA()
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
    PondPediaCustomTheme(darkTheme = true) {
        TabScreen(navItem = BottomNavItem.Ponds)
    }
    
}

//@Preview
//@Composable
//fun fakeTabPreview() {
//    PondPediaCustomTheme(darkTheme = true) {
//        fakeTab()
//    }
//}
//@Composable
//fun fakeTab() {
//    var tabIndex by remember { mutableStateOf(0) }
//    val tabs = listOf("Tab A", "Tab B", "Tab C")
//    Column(modifier = Modifier.fillMaxWidth()) {
//        TabRow(selectedTabIndex = tabIndex, containerColor = MaterialTheme.colorScheme.tertiary) {
//            tabs.forEachIndexed { index, title ->
//                Tab(
//                    text = { Text(title) },
//                    selected = index == tabIndex,
//                    onClick = {
//                        tabIndex = index
//                    }
//                )
//            }
//        }
//        when (tabIndex) {
//            0 -> Unit
//            1 -> Unit
//            2 -> Unit
//        }
//    }
//}

