package com.arjuntu90.logic.model.weather

import com.arjuntu90.logic.api.DataSourceApi
import com.arjuntu90.logic.api.ResultWrapper
import com.arjuntu90.logic.model.RemoteRepository
import com.arjuntu90.logic.model.WeatherResp
import com.arjuntu90.logic.util.NetworkUtils
import javax.inject.Inject

interface WeatherRepo {
    suspend fun getWeather(): ResultWrapper<WeatherResp>
}