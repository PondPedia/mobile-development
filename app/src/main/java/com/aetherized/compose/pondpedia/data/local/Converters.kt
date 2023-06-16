package com.aetherized.compose.pondpedia.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.aetherized.compose.pondpedia.data.util.JsonParser
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromPondDataJson(json: String): List<Pond> {
        return jsonParser.fromJson<ArrayList<Pond>>(
            json,
            object: TypeToken<ArrayList<Pond>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toPondDataJson(pondData: List<Pond>): String {
        return jsonParser.toJson(
            pondData,
            object: TypeToken<ArrayList<Pond>>(){}.type
        ) ?: "[]"
    }
}