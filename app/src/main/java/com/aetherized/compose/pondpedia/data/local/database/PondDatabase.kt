package com.aetherized.compose.pondpedia.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aetherized.compose.pondpedia.data.local.Converters
import com.aetherized.compose.pondpedia.data.local.dao.PondLogDao
import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity


@Database(
    entities = [PondLogEntity::class], version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class PondDatabase : RoomDatabase() {
    abstract val pondLogDao: PondLogDao
}

