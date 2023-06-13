package com.aetherized.compose.pondpedia.data.remote.api

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

interface PondApi {

//    @GET("stories")
//    suspend fun getAllStories(
//        @Header("Authorization") token: String = TOKEN,
//        @Query("page") page: Int = 1,
//        @Query("size") size: Int = 20,
//    ): ResponseBody
//
//    @GET("stories/{id}")
//    suspend fun getStoryDetail(
//        @Header("Authorization") token: String = TOKEN,
//        @Path("id") id: String = STORY_ID
//    ): ResponseBody
//
//    companion object {
//        const val STORY_ID = "story-qgkUzwC4d4TOib99"
//        const val TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1c2VyLU9hbWc5Slc2TGdrMUE3aHYiLCJpYXQiOjE2ODYxMjgwMTd9.BTTWgPvqkXzJrM6LpENGBBEEcvWUTp7vlJny7KOBELI"
//        const val BASE_URL = "https://story-api.dicoding.dev/v1/"
//    }
}