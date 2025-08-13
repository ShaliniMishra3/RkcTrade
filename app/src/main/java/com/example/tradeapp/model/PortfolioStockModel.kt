package com.example.tradeapp.model

data class Stock(
    val qty: String,
    val avg: String,
    val percentChange: String,
    val name: String,
    val invested: String,
    val event: Boolean,
    val ltp: String,
    val change: String
)