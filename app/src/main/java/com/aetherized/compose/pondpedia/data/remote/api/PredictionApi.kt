package com.aetherized.compose.pondpedia.data.remote.api

import com.aetherized.compose.pondpedia.data.remote.dto.PondGrowthPredictionParamDto
import com.aetherized.compose.pondpedia.data.remote.dto.PondWaterDto
import com.aetherized.compose.pondpedia.data.remote.response.GrowthPredictionResponse
import com.aetherized.compose.pondpedia.data.remote.response.WaterPredictionResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PredictionApi {
    @POST("/pondpedia/predict/water")
    suspend fun getPondWaterPrediction(
        @Body pondWater: PondWaterDto,
    ): WaterPredictionResponse

    @POST("/pondpedia/predict/growth")
    suspend fun getPondGrowthPrediction(
        @Body pondWaterPredictionParam: PondGrowthPredictionParamDto,
    ): GrowthPredictionResponse

    companion object {
        const val BASE_URL = "https://pondpediaapi-ismbpqewoa-as.a.run.app/"
    }
}