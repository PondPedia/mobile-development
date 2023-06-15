package com.aetherized.compose.pondpedia.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.Instant

@Parcelize
@Entity(
    tableName = "pond_logs",
    foreignKeys = [
        ForeignKey(
            entity = PondEntity::class,
            parentColumns = ["pId"],
            childColumns = ["pond_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PondLogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "lId")
    val lId: Int? = null,

    @ColumnInfo(name = "pond_id")
    val pondId: Int,

    @Embedded(prefix = "new_")
    val newPond: PondEntity,

    @ColumnInfo(name = "timestamp")
    val timestamp: String = Instant.now().toString()
) : Parcelable
