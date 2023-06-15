package com.aetherized.compose.pondpedia.domain.repository

import com.aetherized.compose.pondpedia.core.util.Resource
import com.aetherized.compose.pondpedia.domain.model.pond.PondLog
import kotlinx.coroutines.flow.Flow

interface PondLogRepository {

    fun getPondLog(pondId: String): Flow<Resource<List<PondLog>>>

    fun getLocalPondLog(pondId: String): Flow<Resource<List<PondLog>>>
}