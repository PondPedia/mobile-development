package com.aetherized.compose.pondpedia.domain.repository

import com.aetherized.compose.pondpedia.core.Resource
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import kotlinx.coroutines.flow.Flow

interface PondRepository {
    suspend fun getPonds(
        fetchFromRemote: Boolean,
    ): Flow<Resource<List<Pond>>>
}