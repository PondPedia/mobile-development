package com.aetherized.compose.pondpedia.data.remote

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

//    ========== USER ==========
    @POST("register")
    suspend fun register(
        @Body requestBody: Map<String, String>
    ): ResponseBody

    @POST("login")
    suspend fun login(
        @Body requestBody: Map<String, String>
    ): ResponseBody


//    ========== STORY ==========
    @Multipart
    @POST("stories")
    suspend fun addNewStory(
        @Header("Authorization") token: String,
        @Part("description") description: RequestBody,
        @Part photo: MultipartBody.Part
    ): ResponseBody

    @Multipart
    @POST("stories/guest")
    suspend fun addNewStoryGuest(
        @Part("description") description: RequestBody,
        @Part photo: MultipartBody.Part
    ): ResponseBody

    @GET("stories")
    suspend fun getAllStories(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): ResponseBody

    @GET("stories/{id}")
    suspend fun getStoryDetail(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): ResponseBody

}