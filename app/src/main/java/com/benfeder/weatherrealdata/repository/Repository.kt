package com.benfeder.weatherrealdata.repository

import com.benfeder.weatherrealdata.api.RetrofitInstance
import com.benfeder.weatherrealdata.model.DailyWeather
import retrofit2.Response

class Repository {
    suspend fun getWeeklyWeather(): Response<DailyWeather> {
        return RetrofitInstance.api.getWeeklyWeather()
    }
}