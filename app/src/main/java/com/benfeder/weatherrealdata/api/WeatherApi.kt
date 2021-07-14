package com.benfeder.weatherrealdata.api

import com.benfeder.weatherrealdata.model.DailyWeather
import com.benfeder.weatherrealdata.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("onecall?lat=39.9526&lon=-75.1652&units=imperial&exclude=minutely,pop&appid=${Constants.API_KEY}")
    suspend fun getWeeklyWeather() : Response<DailyWeather>
}