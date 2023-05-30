package com.aetherized.view.pondpediaview.data.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.data.local.room.dao.PondDao

@Database(entities = [PondEntity::class], version = 1, exportSchema = false)
abstract class PondDatabase : RoomDatabase() {
    abstract fun pondDao(): PondDao

    companion object {
        @Volatile
        private var INSTANCE: PondDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): PondDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    PondDatabase::class.java,
                    "pond.database"
                ).build()
            }
    }
}