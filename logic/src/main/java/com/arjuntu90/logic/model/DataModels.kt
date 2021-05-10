package com.arjuntu90.logic.model

import com.arjuntu90.logic.db.WeatherItem

data class WeatherResp(
    val product: String,
    val dataseries: List<WeatherItem>,
)