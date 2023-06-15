package com.aetherized.compose.pondpedia.presentation.home.ponds.components

import com.aetherized.compose.pondpedia.domain.model.pond.PondLog

data class PondsState (
    val pondLogItems: List<PondLog> = emptyList(),
    val isLoading: Boolean = false,
)