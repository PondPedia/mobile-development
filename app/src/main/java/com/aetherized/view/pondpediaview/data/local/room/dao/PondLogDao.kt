package com.aetherized.view.pondpediaview.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.data.local.entity.PondLogEntity
import com.aetherized.view.pondpediaview.data.local.entity.UpdatesEntity
import com.aetherized.view.pondpediaview.data.model.PondWithUpdates

@Dao
interface PondLogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPondLog(pondLogEntity: PondLogEntity): Long

    @Update
    suspend fun updatePondLog(pondLogEntity: PondLogEntity)

    @Delete
    suspend fun deletePondLog(pondLogEntity: PondLogEntity)

    @Query("DELETE FROM pond_logs")
    fun deleteAllPondLogs()

    @Query("SELECT * from pond_logs ORDER BY id ASC")
    fun getAllPondLogs(): LiveData<List<PondLogEntity>>

}