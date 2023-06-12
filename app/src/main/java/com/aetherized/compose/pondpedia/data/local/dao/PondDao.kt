package com.aetherized.compose.pondpedia.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.aetherized.compose.pondpedia.data.local.entity.PondEntity

@Dao
interface PondDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPond(pond: PondEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPonds(pondList: List<PondEntity>)

    @Update
    suspend fun updatePond(pond: PondEntity)

    @Delete
    suspend fun deletePond(pond: PondEntity)

    @Query("DELETE FROM ponds")
    fun deleteAllPonds()

    @Query("SELECT * from ponds")
    fun getAllPonds(): LiveData<List<PondEntity>>

    @Query("SELECT * FROM ponds WHERE pId = :pondId")
    fun getPondById(pondId: Int): LiveData<PondEntity>
}