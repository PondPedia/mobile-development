package com.aetherized.view.pondpediaview.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity

@Dao
interface PondDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPond(pondEntity: PondEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPonds(pondEntityList: List<PondEntity>)

    @Update
    suspend fun updatePond(pondEntity: PondEntity)

    @Delete
    suspend fun deletePond(pondEntity: PondEntity)

    @Query("DELETE FROM ponds")
    fun deleteAllPonds()

    @Query("SELECT * from ponds ORDER BY id ASC")
    fun getAllPonds(): LiveData<List<PondEntity>>
}
