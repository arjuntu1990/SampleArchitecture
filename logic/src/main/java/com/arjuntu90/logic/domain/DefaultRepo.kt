package com.arjuntu90.logic.domain

import com.arjuntu90.logic.api.DataSourceApi
import com.arjuntu90.logic.api.ResultWrapper
import com.arjuntu90.logic.db.AppDatabase
import com.arjuntu90.logic.model.RemoteRepository
import com.arjuntu90.logic.model.WeatherResp
import com.arjuntu90.logic.model.weather.WeatherRepo
import com.arjuntu90.logic.util.NetworkUtils
import javax.inject.Inject

class DefaultRepo @Inject constructor(
    private val dataSourceApi: DataSourceApi,
    private val appDatabase: AppDatabase,
    networkUtils: NetworkUtils
) : RemoteRepository(networkUtils), WeatherRepo {

    override suspend fun getWeather(): ResultWrapper<WeatherResp> {
        return when(val result = execute { dataSourceApi.getWeather() }) {
            is ResultWrapper.Success -> ResultWrapper.Success(result.data)
            is ResultWrapper.Error -> ResultWrapper.Error(result.e)
            is ResultWrapper.Loading -> ResultWrapper.Loading
            else -> ResultWrapper.Error(Exception("Error unknown"))
        }
    }
}