package com.aetherized.compose.pondpedia.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aetherized.compose.pondpedia.domain.models.pond.PondFeed
import com.aetherized.compose.pondpedia.domain.models.pond.PondFish
import com.aetherized.compose.pondpedia.domain.models.pond.PondWater
import kotlinx.parcelize.Parcelize
import java.time.Instant

@Parcelize
@Entity(tableName = "ponds")
data class PondEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pId")
    val pId: Int? = null,

    @ColumnInfo(name = "pond_name")
    val pondName: String,

    @ColumnInfo(name = "pond_length")
    val pondLength: Float,

    @ColumnInfo(name = "pond_width")
    val pondWidth: Float,

    @ColumnInfo(name = "pond_depth")
    val pondDepth: Float,

    @ColumnInfo(name = "pond_image_url")
    val pondImageUrl: String? = null,

    @Embedded(prefix = "pond_fish_")
    val pondFish: PondFish,

    @Embedded(prefix = "pond_feed_")
    val pondFeed: PondFeed,

    @Embedded(prefix = "pond_water_")
    val pondWater: PondWater,

    @ColumnInfo(name = "created_at")
    val createdAt: String? = Instant.now().toString(),

    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = Instant.now().toString(),
) : Parcelable