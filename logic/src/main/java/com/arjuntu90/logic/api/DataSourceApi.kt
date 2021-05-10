package com.arjuntu90.logic.api

import com.arjuntu90.logic.model.WeatherResp
import retrofit2.Response
import retrofit2.http.GET

interface DataSourceApi {

    @GET("/bin/astro.php?lon=113.2&lat=22&ac=0&unit=metric&output=json&tzshift=0")
    suspend fun getWeather(): Response<WeatherResp>
}