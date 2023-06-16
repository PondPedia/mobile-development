package com.aetherized.compose.pondpedia.presentation.home.ponds.components

import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.PondLog
import com.aetherized.compose.pondpedia.domain.model.pond.getDummyPond

data class PondState (
    val pondLogItems: List<PondLog> = emptyList(),
    val isLoading: Boolean = false,
    val pondData: Pond = getDummyPond()
)