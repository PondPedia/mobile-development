package com.aetherized.compose.pondpedia.data.remote.api

import com.aetherized.compose.pondpedia.data.local.entity.PondLogEntity
import com.aetherized.compose.pondpedia.data.remote.response.BaseResponse
import com.aetherized.compose.pondpedia.data.remote.response.PondLogsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PondApi {
    @POST("/pondpedia/ponds/{pond_id}/logs")
    suspend fun insertPondLogs(
//        @Header("Authorization") user_id: String,
        @Path("pond_id") pond_id: String,
        @Body pondLogs: List<PondLogEntity>
    ): BaseResponse


    @GET("/pondpedia/ponds")
    suspend fun getPondLogs(
//        @Header("Authorization") user_id: String,
        @Query("pond_id") size: Int,
    ): PondLogsResponse

    @GET("/pondpedia/ponds/{pond_id}")
    suspend fun getPondLogsById(
//        @Header("Authorization") user_id: String,
        @Path("pond_id") pond_id: String,
    ): PondLogsResponse

    companion object {
        const val BASE_URL = "https://pondpediaapi-ismbpqewoa-as.a.run.app/"
    }
}