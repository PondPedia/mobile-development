package com.aetherized.compose.pondpedia.data.remote.dto

import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity

data class PondLogDto(
    val logId: Int,
    val userId: String?,
    val pondData: List<PondDto>,
    val pondId: String = pondData.last().pondId,
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