package com.aetherized.compose.pondpedia.domain.model.pond

import android.os.Parcelable
import com.aetherized.compose.pondpedia.data.remote.dto.PondWaterDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class PondWater(
    var temperature: Float,
    var turbidity: Float,
    var dissolvedOxygen: Float,
    var pH: Float,
    var ammonia: Float,
    var nitrate: Float,
): Parcelable {
    fun toPondWaterDto(): PondWaterDto {
        return PondWaterDto(
            temperature = temperature,
            turbidity = turbidity,
            dissolvedOxygen = dissolvedOxygen,
            pH = pH,
            ammonia = ammonia,
            nitrate = nitrate,
        )
    }
}
