package com.example.tradeapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiService {
    @POST("api/UserApi/UserLogin")
    fun loginUser(
        @Header("Authorization") authKey: String,
        @Body request: LoginRequest
    ): Call<LoginResponse>
}
/*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST



interface ApiService {
    @POST("api/UserApi/UserLogin")
    fun loginUser(
        @Header("Authorization") authKey: String,
        @Body request: LoginRequest
    ): Call<LoginResponse>
}
*/
