package com.benfeder.weatherrealdata.api

import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.provider.SyncStateContract
import com.benfeder.weatherrealdata.utils.Constants
import com.benfeder.weatherrealdata.utils.Constants.URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(Constants.URL).addConverterFactory(MoshiConverterFactory.create()).build()
    }

    val api: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }
}