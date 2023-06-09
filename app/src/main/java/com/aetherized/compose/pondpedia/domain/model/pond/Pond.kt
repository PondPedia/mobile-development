package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Parcelize
data class Pond(
    var pondName: String,

    var pondLength: Float,

    var pondWidth: Float,

    var pondDepth: Float,

    val pondImageUrl: String? = null,

    val pondFish: PondFish,

    val pondFeed: PondFeed,

    val pondWater: PondWater,

    var pondWaterPrediction: PondWaterPrediction?,

    val pondGrowthPrediction: PondGrowthPrediction?,

    val createdAt: String = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()),

    val updatedAt: String = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()),

    val pondId: String = "pond-${UUID.randomUUID()}",
) : Parcelable


fun getDummyPond() : Pond {
    return Pond(
        pondName = "Pond ${(0..9).random()}.${(0..9).random()}.${(0..9).random()}.",
        pondLength = 5f,
        pondWidth = 5f,
        pondDepth = 2f,
        pondImageUrl = null,
        pondFish = PondFish(
            fishId = "fish-1",
            fishCommonName = "African Catfish",
            fishScientificName = "Clarias gariepinus",
            fishAmount = 100,
            fishTargetWeight = 400f,
            fishCurrentWeight = 10f,
            fishCurrentLength = 8f,
        ),
        pondFeed = PondFeed(),
        pondWater = PondWater(
            temperature = 30f,
            turbidity = 100f,
            dissolvedOxygen = 30f,
            pH = 7f,
            ammonia = 0.5f,
            nitrate = "${(0..1).random()}.${(0..9).random()}".toFloat(),
        ),
        pondWaterPrediction = PondWaterPrediction(),
        pondGrowthPrediction = PondGrowthPrediction(),
        createdAt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()),
        updatedAt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now()),
        pondId = "pond-${UUID.randomUUID()}",
    )
}
fun getDummyPondList(size: Int): List<Pond> {
    val pondList = ArrayList<Pond>()
    for (i in 1..size) {
        pondList.add(getDummyPond())
    }
    return pondList.toList()
}