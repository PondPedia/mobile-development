package com.aetherized.view.pondpediaview.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aetherized.view.pondpediaview.data.model.PondFeed
import com.aetherized.view.pondpediaview.data.model.PondFish
import com.aetherized.view.pondpediaview.data.model.PondWater
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "ponds")
data class PondEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "pond_name")
    var pondName: String,

    @ColumnInfo(name = "pondLength")
    var pondLength: Float,

    @ColumnInfo(name = "pond_width")
    var pondWidth: Float,

    @ColumnInfo(name = "pond_depth")
    var pondDepth: Float,

    @Embedded(prefix = "pond_fish_")
    var pondFish: PondFish,

    @Embedded(prefix = "pond_feed_")
    var pondFeed: PondFeed,

    @Embedded(prefix = "pond_water_")
    var pondWater: PondWater,

    @ColumnInfo(name = "created_at")
    var createdAt: String? = null,

    @ColumnInfo(name = "updated_at")
    var updatedAt: String? = null,

    @ColumnInfo(name = "pond_image")
    var pondImage: String? = null,
) : Parcelable