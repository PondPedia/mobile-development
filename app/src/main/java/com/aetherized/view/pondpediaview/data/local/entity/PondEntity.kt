package com.aetherized.view.pondpediaview.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aetherized.view.pondpediaview.data.model.PondFeed
import com.aetherized.view.pondpediaview.data.model.PondFish
import com.aetherized.view.pondpediaview.data.model.PondWater
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "ponds")
data class PondEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "pond_name")
    val pondName: String,

    @ColumnInfo(name = "pond_length")
    val pondLength: Float,

    @ColumnInfo(name = "pond_width")
    val pondWidth: Float,

    @ColumnInfo(name = "pond_depth")
    val pondDepth: Float,

    @Embedded(prefix = "pond_fish_")
    val pondFish: PondFish,

    @Embedded(prefix = "pond_feed_")
    val pondFeed: PondFeed,

    @Embedded(prefix = "pond_water_")
    val pondWater: PondWater,

    @ColumnInfo(name = "created_at")
    val createdAt: String? = null,

    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = null,

    @ColumnInfo(name = "pond_image")
    val pondImage: String? = null,
) : Parcelable