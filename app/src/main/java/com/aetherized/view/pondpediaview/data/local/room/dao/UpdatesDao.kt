package com.aetherized.view.pondpediaview.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aetherized.view.pondpediaview.data.local.entity.UpdatesEntity

@Dao
interface UpdatesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdates(updatesEntity: UpdatesEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUpdates(updatesEntityList: List<UpdatesEntity>)

    @Update
    suspend fun updateUpdates(updatesEntity: UpdatesEntity)

    @Delete
    suspend fun deleteUpdates(updatesEntity: UpdatesEntity)

    @Query("DELETE FROM updates")
    fun deleteAllUpdates()

    @Query("SELECT * from updates ORDER BY id ASC")
    fun getAllUpdates(): LiveData<List<UpdatesEntity>>
}