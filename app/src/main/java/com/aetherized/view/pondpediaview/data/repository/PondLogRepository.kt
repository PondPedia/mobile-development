package com.aetherized.view.pondpediaview.data.repository

import com.aetherized.view.pondpediaview.data.local.entity.PondLogEntity
import com.aetherized.view.pondpediaview.data.local.room.dao.PondLogDao
import com.aetherized.view.pondpediaview.data.remote.retrofit.ApiService
import com.aetherized.view.pondpediaview.utils.AppExecutors

class PondLogRepository (
    private val apiService: ApiService,
    private val pondLogDao: PondLogDao,
    private val appExecutors: AppExecutors
) {
    val allPondLogs = pondLogDao.getAllPondLogs()

    suspend fun insertPondLog(pondLog: PondLogEntity): Long {
        return pondLogDao.insertPondLog(pondLog)
    }

    companion object {
        @Volatile
        private var instance: PondLogRepository? = null
        fun getInstance(
            apiService: ApiService,
            pondLogDao: PondLogDao,
            appExecutors: AppExecutors
        ): PondLogRepository =
            instance ?: synchronized(this) {
                instance ?: PondLogRepository( apiService, pondLogDao, appExecutors )
            }.also { instance = it }
    }
}