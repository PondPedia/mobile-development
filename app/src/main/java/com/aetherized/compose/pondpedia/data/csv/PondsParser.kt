package com.aetherized.compose.pondpedia.data.csv

import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.PondFeed
import com.aetherized.compose.pondpedia.domain.model.pond.PondFish
import com.aetherized.compose.pondpedia.domain.model.pond.PondWater
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

class PondsParser @Inject constructor(): CSVParser<Pond> {
    override suspend fun parse(stream: InputStream): List<Pond> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO) {
            csvReader
                .readAll()
                .drop(1)
                .mapNotNull { line ->
                    val pId = line.getOrNull(0)
                    val pond_name = line.getOrNull(1)
                    val pond_length = line.getOrNull(2)
                    val pond_width = line.getOrNull(3)
                    val pond_depth = line.getOrNull(4)
                    val pond_image_url = line.getOrNull(5)
                    val fid = line.getOrNull(6)
                    val fish_name = line.getOrNull(7)
                    val fish_scientific_name = line.getOrNull(8)
                    val fish_amount = line.getOrNull(9)
                    val fish_harvest = line.getOrNull(10)
                    val fish_weight = line.getOrNull(11)
                    val fish_length = line.getOrNull(12)
                    val feed_name = line.getOrNull(13)
                    val feed_percentage = line.getOrNull(14)
                    val feed_protein = line.getOrNull(15)
                    val feed_lipid = line.getOrNull(16)
                    val feed_carbs = line.getOrNull(17)
                    val feed_others = line.getOrNull(18)
                    val feed_frequency = line.getOrNull(19)
                    val water_temperature = line.getOrNull(20)
                    val water_turbidity = line.getOrNull(21)
                    val water_oxygen = line.getOrNull(22)
                    val water_ph = line.getOrNull(23)
                    val water_ammonia = line.getOrNull(24)
                    val water_nitrate = line.getOrNull(25)
                    val created_at = line.getOrNull(26)
                    val updated_at = line.getOrNull(27)
                    Pond(
                        pId?.toInt() ?: return@mapNotNull null,
                        pond_name ?: return@mapNotNull null,
                        pond_length?.toFloat() ?: return@mapNotNull null,
                        pond_width?.toFloat() ?: return@mapNotNull null,
                        pond_depth?.toFloat() ?: return@mapNotNull null,
                        pond_image_url ?: return@mapNotNull null,
                        PondFish(
                            fid?.toInt() ?: return@mapNotNull null,
                            fish_name ?: return@mapNotNull null,
                            fish_scientific_name ?: return@mapNotNull null,
                            fish_amount?.toFloat() ?: return@mapNotNull null,
                            fish_harvest?.toFloat() ?: return@mapNotNull null,
                            fish_weight?.toFloat() ?: return@mapNotNull null,
                            fish_length?.toFloat() ?: return@mapNotNull null,
                        ),
                        PondFeed(
                            feed_name ?: return@mapNotNull null,
                            feed_percentage?.toFloat() ?: return@mapNotNull null,
                            feed_protein?.toFloat() ?: return@mapNotNull null,
                            feed_lipid?.toFloat() ?: return@mapNotNull null,
                            feed_carbs?.toFloat() ?: return@mapNotNull null,
                            feed_others?.toFloat() ?: return@mapNotNull null,
                            feed_frequency?.toInt() ?: return@mapNotNull null,
                        ),
                        PondWater(
                            water_temperature?.toFloat() ?: return@mapNotNull null,
                            water_turbidity?.toFloat() ?: return@mapNotNull null,
                            water_oxygen?.toFloat() ?: return@mapNotNull null,
                            water_ph?.toFloat() ?: return@mapNotNull null,
                            water_ammonia?.toFloat() ?: return@mapNotNull null,
                            water_nitrate?.toFloat() ?: return@mapNotNull null,
                        ),
                        createdAt  = created_at,
                        updatedAt = updated_at

                    )
                }
        }
    }
}