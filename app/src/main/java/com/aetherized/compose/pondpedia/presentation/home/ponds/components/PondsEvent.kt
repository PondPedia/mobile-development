package com.aetherized.compose.pondpedia.presentation.home.ponds.components

sealed class PondsEvent {
    object Refresh: PondsEvent()
}
