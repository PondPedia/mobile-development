package com.aetherized.compose.pondpedia.domain.models.pond

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
data class Pond(
    val pId: Int? = null,

    val pondName: String,

    val pondLength: Float,

    val pondWidth: Float,

    val pondDepth: Float,

    val pondFish: PondFish,

    val pondFeed: PondFeed,

    val pondWater: PondWater,

    val createdAt: String? = Instant.now().toString(),

    val updatedAt: String? = Instant.now().toString(),

    val pondImageUrl: String? = null,
) : Parcelable