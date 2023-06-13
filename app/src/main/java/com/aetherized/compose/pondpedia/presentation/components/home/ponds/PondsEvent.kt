package com.aetherized.compose.pondpedia.presentation.components.home.ponds

sealed class PondsEvent {
    object Refresh: PondsEvent()
}
