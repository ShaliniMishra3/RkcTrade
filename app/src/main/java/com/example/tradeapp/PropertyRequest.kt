package com.example.tradeapp

import com.google.gson.annotations.SerializedName

data class PropertyRequest(
    @SerializedName("PropertyId")
    val propertyId: String
)