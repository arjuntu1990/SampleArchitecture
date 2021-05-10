package com.arjuntu90.logic.domain.weather

import com.arjuntu90.logic.api.ResultWrapper
import com.arjuntu90.logic.di.IODispatcher
import com.arjuntu90.logic.domain.SuspendUseCase
import com.arjuntu90.logic.model.WeatherResp
import com.arjuntu90.logic.model.weather.WeatherRepo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class WeatherUsecase @Inject constructor(
    private val repo: WeatherRepo,
    @IODispatcher ioDispatcher: CoroutineDispatcher
    ) : SuspendUseCase<Unit, WeatherResp>(ioDispatcher) {
    override suspend fun execute(parameter: Unit): WeatherResp {
        return when (val result = repo.getWeather()) {
            is ResultWrapper.Success -> result.data
            is ResultWrapper.Error -> throw result.e
            is ResultWrapper.Loading -> throw IllegalStateException("Illegal state exception")
        }
    }
}