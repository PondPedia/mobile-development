package com.aetherized.compose.pondpedia.domain.model.pond

data class PondLog(
    val userId: String?,
    val pondId: String,
    val pondData: List<Pond>,
)
