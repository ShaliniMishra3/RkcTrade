package com.example.tradeapp.model

import com.google.gson.annotations.SerializedName

data class PropertyItem(

    @SerializedName("PropertyId")
    val propertyId: Int,

    @SerializedName("Property_name")
    val propertyName: String,

    @SerializedName("Property_Address")
    val propertyAddress: String,

    @SerializedName("Area")
    val area: Double,

    @SerializedName("Rate")
    val rate: Double,

    @SerializedName("Balance_area")
    val balanceArea: Double

    /*
    val PropertyId: Int,
    val Property_name: String,
    val Property_Address: String,
    val Area: Double,
    val Rate: Double,
    val Balance_area: Double


     */
)