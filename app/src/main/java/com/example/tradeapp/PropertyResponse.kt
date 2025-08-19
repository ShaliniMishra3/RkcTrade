package com.example.tradeapp

import com.example.tradeapp.model.PropertyItem
import com.google.gson.annotations.SerializedName


data class PropertyResponse(
    @SerializedName("data")
    val data: List<PropertyItem>
)