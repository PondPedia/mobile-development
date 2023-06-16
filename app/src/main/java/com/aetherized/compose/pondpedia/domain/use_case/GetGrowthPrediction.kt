package com.aetherized.compose.pondpedia.domain.use_case

import com.aetherized.compose.pondpedia.core.util.Resource
import com.aetherized.compose.pondpedia.domain.model.pond.PondLog
import com.aetherized.compose.pondpedia.domain.repository.PondLogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGrowthPrediction (
    private val repository: PondLogRepository
) {
    operator fun invoke(pondId: String): Flow<Resource<List<PondLog>>> {
        if(pondId.isEmpty()) {
            return flow { }
        }
        return repository.getLocalPondLog(pondId)
    }
}