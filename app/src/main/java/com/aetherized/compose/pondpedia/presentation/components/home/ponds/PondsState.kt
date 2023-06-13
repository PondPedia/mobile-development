package com.aetherized.compose.pondpedia.presentation.components.home.ponds

import com.aetherized.compose.pondpedia.domain.model.pond.Pond

data class PondsState (
    val ponds: List<Pond> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val query: String = "",
    val token: String = "Bearer ",
)