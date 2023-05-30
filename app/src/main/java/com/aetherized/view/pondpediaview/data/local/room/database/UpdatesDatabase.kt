package com.aetherized.view.pondpediaview.data.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aetherized.view.pondpediaview.data.local.entity.UpdatesEntity
import com.aetherized.view.pondpediaview.data.local.room.dao.UpdatesDao

@Database(entities = [UpdatesEntity::class], version = 1, exportSchema = false)
abstract class UpdatesDatabase : RoomDatabase() {
    abstract fun updatesDao(): UpdatesDao

    companion object {
        @Volatile
        private var INSTANCE: UpdatesDatabase? = null

        fun getDatabase(context: Context): UpdatesDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    UpdatesDatabase::class.java,
                    "updates.database"
                ).build().also { INSTANCE = it }
            }
    }
}