package com.aetherized.view.pondpediaview.data.model

import androidx.room.Embedded
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity

data class PondWithUpdates(
    @Embedded
    val pond: PondEntity,
//
//    @Relation(parentColumn = "id", entityColumn = "pond_id")
//    val updates: List<UpdatesEntity>
)
