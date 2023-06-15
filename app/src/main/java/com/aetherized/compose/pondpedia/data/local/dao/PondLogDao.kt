package com.aetherized.compose.pondpedia.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity

@Dao
interface PondLogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPondLog(pondLog: PondLogEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPondLogs(pondLogs: List<PondLogEntity>)
    @Query("DELETE FROM pond_logs")
    fun deleteAllPondLogs()

    @Query("DELETE FROM pond_logs WHERE pond_id IN (:pondIds)")
    suspend fun deletePondLogs(pondIds: List<String>)

    @Query("SELECT * FROM pond_logs WHERE pond_id LIKE '%' || :pondId || '%'")
    fun getPondLogByPondId(pondId: String): List<PondLogEntity>
}