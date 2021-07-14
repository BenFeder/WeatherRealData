package com.benfeder.weatherrealdata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benfeder.weatherrealdata.model.DailyWeather
import com.benfeder.weatherrealdata.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel(private val repository: Repository) : ViewModel() {
    private val _data : MutableLiveData<Response<DailyWeather>> = MutableLiveData()

    fun getData() : LiveData<Response<DailyWeather>> {
        return _data
    }

    fun getWeeklyWeather(){
        viewModelScope.launch {
            val res: Response<DailyWeather> = repository.getWeeklyWeather()
            _data.value = res
        }
    }

}