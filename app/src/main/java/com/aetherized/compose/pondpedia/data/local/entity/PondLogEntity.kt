package com.aetherized.compose.pondpedia.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.PondLog

@Entity(
    tableName = "pond_logs",
)
data class PondLogEntity(
    @PrimaryKey
    @ColumnInfo(name = "log_id")
    val logId: Int? = null,

    @ColumnInfo(name = "user_id")
    val userId: String?,

    @ColumnInfo(name = "pond_id")
    val pondId: String,

    @ColumnInfo(name = "pond_")
    val pondData: List<Pond>,
) {
    fun toPondLog(): PondLog {
        return PondLog(
            userId = userId,
            pondId = pondId,
            pondData = pondData ,
        )
    }
}
