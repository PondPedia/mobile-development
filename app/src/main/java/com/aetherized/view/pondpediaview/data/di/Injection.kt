package com.aetherized.view.pondpediaview.data.di

import android.content.Context
import com.aetherized.view.pondpediaview.data.local.room.database.PondDatabase
import com.aetherized.view.pondpediaview.data.local.room.database.UpdatesDatabase
import com.aetherized.view.pondpediaview.data.remote.retrofit.ApiConfig
import com.aetherized.view.pondpediaview.data.repository.PondRepository
import com.aetherized.view.pondpediaview.data.repository.UpdatesRepository
import com.aetherized.view.pondpediaview.utils.AppExecutors

object Injection {
    fun providePondRepository(context: Context): PondRepository {
        val apiService = ApiConfig.getApiService()
        val database = PondDatabase.getDatabase(context)
        val dao = database.pondDao()
        val appExecutors = AppExecutors()
        return PondRepository(apiService, dao, appExecutors)
    }
    fun provideUpdatesRepository(context: Context): UpdatesRepository {
        val apiService = ApiConfig.getApiService()
        val database = UpdatesDatabase.getDatabase(context)
        val dao = database.updatesDao()
        val appExecutors = AppExecutors()
        return UpdatesRepository(apiService, dao, appExecutors)
    }
}