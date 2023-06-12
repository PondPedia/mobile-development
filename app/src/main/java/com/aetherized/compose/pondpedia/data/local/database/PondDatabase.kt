package com.aetherized.compose.pondpedia.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aetherized.compose.pondpedia.data.local.dao.PondDao
import com.aetherized.compose.pondpedia.data.local.dao.PondLogDao
import com.aetherized.compose.pondpedia.data.local.entity.PondEntity
import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity

@Database(
    entities = [PondEntity::class, PondLogEntity::class], version = 1, exportSchema = false
)
abstract class PondDatabase : RoomDatabase() {

    abstract fun pondDao(): PondDao
    abstract fun pondLogDao(): PondLogDao

    companion object {
        @Volatile
        private var INSTANCE: PondDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): PondDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    PondDatabase::class.java,
                    "pondss.db"
                )
                    .build()
            }
    }
}