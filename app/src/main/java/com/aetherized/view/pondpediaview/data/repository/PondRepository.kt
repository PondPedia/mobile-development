package com.aetherized.view.pondpediaview.data.repository

import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.data.local.room.dao.PondDao
import com.aetherized.view.pondpediaview.data.remote.retrofit.ApiService
import com.aetherized.view.pondpediaview.utils.AppExecutors

class PondRepository(
    private val apiService: ApiService,
    private val pondDao: PondDao,
    private val appExecutors: AppExecutors
) {
    val allPonds = pondDao.getAllPonds()

    suspend fun insertPond(pond: PondEntity): Long {
        return pondDao.insertPond(pond)
    }

    suspend fun updatePond(pond: PondEntity) {
        pondDao.updatePond(pond)
    }

    companion object {
        @Volatile
        private var instance: PondRepository? = null
        fun getInstance(
            apiService: ApiService,
            pondDao: PondDao,
            appExecutors: AppExecutors
        ): PondRepository =
            instance ?: synchronized(this) {
                instance ?: PondRepository( apiService, pondDao, appExecutors )
            }.also { instance = it }
    }

}