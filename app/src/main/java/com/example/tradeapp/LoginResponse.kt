package com.example.tradeapp

data class LoginResponse(
    val data: String
)

// Inner parsed response
data class InnerResponse(
    val data: List<UserData>
)

data class UserData(
    val result_status: Int,
    val msg: String,
    val userId: Int,
    val password: String,
    val Name: String,
    val walletAddress: String
)
/*
data class LoginResponse(
    val Success: Boolean,
    val Message: String?,
    val Token: String?
)
*/


