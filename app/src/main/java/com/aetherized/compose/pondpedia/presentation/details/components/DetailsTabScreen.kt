package com.aetherized.compose.pondpedia.presentation.details.components

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
import androidx.compose.ui.unit.sp
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondState
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondViewModel
import com.aetherized.compose.pondpedia.presentation.details.screen.DetailsScreenA
import com.aetherized.compose.pondpedia.presentation.details.screen.DetailsScreenB
import com.aetherized.compose.pondpedia.presentation.details.screen.DetailsScreenC
import com.aetherized.compose.pondpedia.presentation.details.screen.DetailsScreenD

enum class Tab (val title: String) {
    DetailsTabA("Air"),
    DetailsTabB("Ikan"),
    DetailsTabC("Pakan"),
    DetailsTabD("Analisa"),
}

@Composable
fun DetailsTabScreen(
    pondState: PondState,
    pondViewModel: PondViewModel,
) {
    var selectedTab by remember { mutableStateOf(Tab.DetailsTabA) }
    var tabIndex by remember { mutableStateOf(0) }
    val tabs =
        listOf(
            Tab.DetailsTabA,
            Tab.DetailsTabB,
            Tab.DetailsTabC,
            Tab.DetailsTabD,
        )


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
            Tab.DetailsTabA -> DetailsScreenA(pondState = pondState, pondViewModel = pondViewModel)
            Tab.DetailsTabB -> DetailsScreenB(pondState = pondState, pondViewModel = pondViewModel)
            Tab.DetailsTabC -> DetailsScreenC(pondState = pondState, pondViewModel = pondViewModel)
            Tab.DetailsTabD -> DetailsScreenD(pondState = pondState, pondViewModel = pondViewModel)
        }
    }
}

