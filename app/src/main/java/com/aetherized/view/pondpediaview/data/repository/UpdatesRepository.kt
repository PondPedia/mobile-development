package com.aetherized.view.pondpediaview.data.repository

import com.aetherized.view.pondpediaview.data.local.entity.UpdatesEntity
import com.aetherized.view.pondpediaview.data.local.room.dao.UpdatesDao
import com.aetherized.view.pondpediaview.data.remote.retrofit.ApiService
import com.aetherized.view.pondpediaview.utils.AppExecutors

class UpdatesRepository(
    private val apiService: ApiService,
    private val updatesDao: UpdatesDao,
    private val appExecutors: AppExecutors
) {
    val allUpdates = updatesDao.getAllUpdates()

    suspend fun insertUpdates(updates: UpdatesEntity): Long {
        return updatesDao.insertUpdates(updates)
    }

    suspend fun updateUpdates(updates: UpdatesEntity) {
        updatesDao.updateUpdates(updates)
    }

    companion object {
        @Volatile
        private var instance: UpdatesRepository? = null
        fun getInstance(
            apiService: ApiService,
            updatesDao: UpdatesDao,
            appExecutors: AppExecutors
        ): UpdatesRepository =
            instance ?: synchronized(this) {
                instance ?: UpdatesRepository( apiService, updatesDao, appExecutors )
            }.also { instance = it }
    }

}