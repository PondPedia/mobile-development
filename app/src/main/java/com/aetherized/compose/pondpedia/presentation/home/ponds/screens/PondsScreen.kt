package com.aetherized.compose.pondpedia.presentation.home.ponds.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.aetherized.compose.pondpedia.domain.model.pond.getDummyPondLogList
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondItemCard
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme

@Preview
@Composable
fun PondScreenPreview() {
    PondPediaCustomTheme(darkTheme = true) {
//        PondsScreenA()
    }
}
@Composable
fun PondsScreenA() {
    val horizontalGridSize by remember { mutableStateOf(2) }
    LazyVerticalGrid(
        columns = GridCells.Fixed(horizontalGridSize),
        content = {
            val pondLogList = getDummyPondLogList(5)
            items(pondLogList.size) {
                PondItemCard(pond = pondLogList[it].pondData.last())
            }
        })
}

@Composable
fun PondsScreenB() {
}

@Composable
fun PondsScreenC() {
}

@Composable
fun PondsScreenD() {
}