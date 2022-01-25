package io.mx51.androidinterview.data.impl

import io.mx51.androidinterview.data.retrofit.OpenWeatherMapService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenWeatherMapServiceProvider {
    fun provideOpenWeatherMapService(): OpenWeatherMapService {
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenWeatherMapService::class.java)
    }
}