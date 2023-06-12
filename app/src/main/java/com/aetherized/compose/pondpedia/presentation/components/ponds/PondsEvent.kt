package com.aetherized.compose.pondpedia.presentation.components.ponds

sealed class PondsEvent {
    object Refresh: PondsEvent()
}
