package com.aetherized.view.pondpediaview.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aetherized.view.pondpediaview.data.model.PondWater
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pond_logs")
data class PondLogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "pond_id")
    val pondId: Int,

    @ColumnInfo(name = "action")
    val action: String? = null,

    @Embedded(prefix = "pond_")
    val pond: PondEntity,

    @ColumnInfo(name = "timestamp")
    val timestamp: String? = null
) : Parcelable
