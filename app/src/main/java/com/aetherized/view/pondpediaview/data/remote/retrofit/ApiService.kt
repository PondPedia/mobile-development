package com.aetherized.view.pondpediaview.data.remote.retrofit

import com.aetherized.view.pondpediaview.data.model.LoginResult
import com.aetherized.view.pondpediaview.data.remote.response.PondResponse
import com.dicoding.aetherized.aetherizedstoryappview.data.response.GeneralResponse
import com.dicoding.aetherized.aetherizedstoryappview.data.response.UserResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("register")
    suspend fun register(
        @Body requestBody: Map<String, String>
    ): GeneralResponse

    @POST("login")
    suspend fun login(
        @Body requestBody: Map<String, String>
    ): UserResponse<LoginResult>

    @GET("top-headlines?country=id&category=science")
    fun getAllPonds(@Query("apiKey") apiKey: String): Call<PondResponse>
}

