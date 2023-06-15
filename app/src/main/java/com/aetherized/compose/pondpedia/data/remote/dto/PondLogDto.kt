package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity

data class PondLogDto(
    val logId: Int,
    val userId: String?,
    val pondId: String,
    val pondData: List<PondDto>,
){
    fun toPondLogEntity(): PondLogEntity {
        return PondLogEntity(
            logId = logId,
            userId = userId,
            pondId = pondId,
            pondData = pondData.map { it.toPond() } ,
        )
    }
}