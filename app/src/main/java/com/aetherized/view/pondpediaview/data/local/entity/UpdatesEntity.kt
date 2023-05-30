package com.aetherized.view.pondpediaview.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "updates")
data class UpdatesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "updates_category")
    var updatesCategory: String,

    @ColumnInfo(name = "updates_name")
    var updatesName: String,

    @ColumnInfo(name = "updates_content")
    var updatesContent: String?,

    @ColumnInfo(name = "update_details")
    var updatesDetails: String?,
) : Parcelable
