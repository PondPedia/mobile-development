package com.aetherized.compose.pondpedia.data.repository

import android.util.Log
import com.aetherized.compose.pondpedia.core.util.Resource
import com.aetherized.compose.pondpedia.data.local.dao.PondLogDao
import com.aetherized.compose.pondpedia.data.remote.api.PondApi
import com.aetherized.compose.pondpedia.data.remote.api.PredictionApi
import com.aetherized.compose.pondpedia.data.remote.dto.PondWaterDto
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.PondLog
import com.aetherized.compose.pondpedia.domain.repository.PondLogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class PondLogRepositoryImpl(
    private val predictionApi: PredictionApi,
    private val pondApi: PondApi,
    private val dao: PondLogDao
): PondLogRepository {

    override fun getWaterPrediction(pondWaterDto: PondWaterDto): Flow<Resource<List<PondLog>>> {
//        emit(Resource.Loading())
//
//        val waterPredictions = pondApi.
        return flow {  }
    }
    override fun getPondLog(pondId: String): Flow<Resource<List<PondLog>>> = flow {
        emit(Resource.Loading())

        val pondLogs = dao.getPondLogByPondId(pondId).map { it.toPondLog() }
        emit(Resource.Loading(data = pondLogs))

        try {
            val remotePondLogs =  pondApi.getPondLogsById(pondId)
            dao.deletePondLogs(remotePondLogs.data.map { it.pondId })
            dao.insertPondLogs(remotePondLogs.data.map { it.toPondLogEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Terjadi Kesalahan!",
                data = pondLogs
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Koneksi Bermasalah!",
                data = pondLogs
            ))
        }

        val newPondLogs = dao.getPondLogByPondId(pondId).map { it.toPondLog() }
        emit(Resource.Success(newPondLogs))
    }

    override fun getLocalPondLog(pondId: String): Flow<Resource<List<PondLog>>> = flow {
        emit(Resource.Loading())

        val pondLogsEntity = dao.getPondLogByPondId(pondId)
        val pondLogs = pondLogsEntity.map { it.toPondLog() }
        emit(Resource.Loading(data = pondLogs))

        try {
            val remotePondLogs =  pondApi.insertPondLogs(pondId, pondLogsEntity)
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = e.toString(),
                data = pondLogs
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = e.toString(),
                data = pondLogs
            ))
        }

        emit(Resource.Success(pondLogs))
    }

    override suspend fun addLocalPondLog(userId: String?, pond: Pond) {

        val pondLog = when(userId?.isEmpty()) {
            true -> {
                PondLog(
                    pondData = listOf(pond),
                    pondId = pond.pondId
                )

            }
            false -> {
                PondLog(
                    userId = userId,
                    pondData = listOf(pond),
                    pondId = pond.pondId
                )
            }

            null -> {
                PondLog(
                    pondData = listOf(pond),
                    pondId = pond.pondId
                )
            }
        }
        try {
            dao.insertPondLog(pondLog.toPondLogEntity())
        } catch (e: HttpException) {
            Log.d("PondLogRepositoryImpl", e.toString())
        } catch (e: IOException) {
            Log.d("PondLogRepositoryImpl", e.toString())
        }

    }
}