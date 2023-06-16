package com.aetherized.compose.pondpedia.presentation.home.ponds.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondItemCard
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondState
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondViewModel
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme

@Preview
@Composable
fun PondScreenPreview() {
    PondPediaCustomTheme(darkTheme = true) {
//        PondsScreenA()
    }
}
@Composable
fun PondsScreenA(
    pondState: PondState,
    pondViewModel: PondViewModel,
    onClickItem: () -> Unit
) {
    pondViewModel.onLoadPonds("pond")
    val horizontalGridSize by remember { mutableStateOf(2) }
    LazyVerticalGrid(
        columns = GridCells.Fixed(horizontalGridSize),
        content = {
            val pondLogList = pondState.pondLogItems
            items(pondLogList.size) {
                PondItemCard(
                    pond = pondLogList[it].pondData.last(),
                    pondViewModel = pondViewModel,
                    onClickItem = onClickItem
                )
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