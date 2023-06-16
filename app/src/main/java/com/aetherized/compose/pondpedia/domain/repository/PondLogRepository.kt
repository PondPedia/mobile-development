package com.aetherized.compose.pondpedia.domain.repository

import com.aetherized.compose.pondpedia.core.util.Resource
import com.aetherized.compose.pondpedia.data.remote.dto.PondWaterDto
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.PondLog
import kotlinx.coroutines.flow.Flow

interface PondLogRepository {

    fun getWaterPrediction(pondWaterDto: PondWaterDto): Flow<Resource<List<PondLog>>>

    fun getPondLog(pondId: String): Flow<Resource<List<PondLog>>>

    fun getLocalPondLog(pondId: String): Flow<Resource<List<PondLog>>>

    suspend fun addLocalPondLog(userId: String?, pond: Pond)
}