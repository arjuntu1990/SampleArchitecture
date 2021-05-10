package com.arjuntu90.logic.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherItem(
    @PrimaryKey val timepoint: String,
    val cloudcover: String,
    val seeing: String,
    val transparency: String,
    val temp2m: String,
)