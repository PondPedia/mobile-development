package com.aetherized.compose.pondpedia.data.repository

import com.aetherized.compose.pondpedia.core.util.Resource
import com.aetherized.compose.pondpedia.data.local.dao.PondLogDao
import com.aetherized.compose.pondpedia.data.remote.api.PondApi
import com.aetherized.compose.pondpedia.domain.model.pond.PondLog
import com.aetherized.compose.pondpedia.domain.repository.PondLogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class PondLogRepositoryImpl(
    private val api: PondApi,
    private val dao: PondLogDao
): PondLogRepository {
    override fun getPondLog(pondId: String): Flow<Resource<List<PondLog>>> = flow {
        emit(Resource.Loading())

        val pondLogs = dao.getPondLogByPondId(pondId).map { it.toPondLog() }
        emit(Resource.Loading(data = pondLogs))

        try {
            val remotePondLogs =  api.getPondLogsById(pondId)
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
            val remotePondLogs =  api.insertPondLogs(pondId, pondLogsEntity)
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
}