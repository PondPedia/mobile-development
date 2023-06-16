package com.aetherized.compose.pondpedia.domain.model.pond

import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity
import java.util.UUID

data class PondLog(
    val userId: String? = "local-${UUID.randomUUID()}",
    val pondData: List<Pond>,
    val pondId: String = pondData.last().pondId,
){
    fun toPondLogEntity(): PondLogEntity {
        return PondLogEntity(
            userId = userId,
            pondId = pondId,
            pondData = pondData ,
        )
    }
}


fun getDummyPondLog(size: Int): PondLog {
    return PondLog(
        userId = "local-${UUID.randomUUID()}",
        pondId = "pond-${UUID.randomUUID()}",
        pondData = getDummyPondList(size)
    )
}


fun getDummyPondLogList(size: Int, min: Int = 1, max: Int = 5): List<PondLog> {
    val pondLogList = ArrayList<PondLog>()
    for (i in 1..size) {
        pondLogList.add(getDummyPondLog((min..max).random()))
    }
    return pondLogList.toList()
}
