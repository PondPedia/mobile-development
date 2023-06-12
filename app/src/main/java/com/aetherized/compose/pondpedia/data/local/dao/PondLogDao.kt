package com.aetherized.compose.pondpedia.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity

@Dao
interface PondLogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPondLog(pondLog: PondLogEntity): Long

    @Update
    suspend fun updatePondLog(pondLog: PondLogEntity)

    @Delete
    suspend fun deletePondLog(pondLog: PondLogEntity)

    @Query("DELETE FROM pond_logs")
    fun deleteAllPondLogs()

    @Query("SELECT * FROM pond_logs WHERE pond_id = :pondId")
    fun getPondLogsByPondId(pondId: Int): LiveData<List<PondLogEntity>>
}