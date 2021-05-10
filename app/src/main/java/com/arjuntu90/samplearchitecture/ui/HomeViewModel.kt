package com.arjuntu90.samplearchitecture.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjuntu90.logic.api.ResultWrapper
import com.arjuntu90.logic.db.WeatherItem
import com.arjuntu90.logic.domain.weather.WeatherUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(useCase: WeatherUsecase) : ViewModel() {
    val weatherData = MutableLiveData<List<WeatherItem>>()
    val loading = MutableLiveData<Boolean>()
    val toast = MutableLiveData<String>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = useCase(Unit)) {
                is ResultWrapper.Success -> {
                    loading.postValue(false)
                    weatherData.postValue(result.data.dataseries)
                }
                is ResultWrapper.Error -> {
                    loading.postValue(false)
                    toast.postValue(result.e.message)
                }
                is ResultWrapper.Loading -> loading.postValue(true)
            }
        }
    }
}