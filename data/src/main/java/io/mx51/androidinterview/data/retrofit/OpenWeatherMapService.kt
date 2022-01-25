package io.mx51.androidinterview.data.retrofit

import retrofit2.http.GET

interface OpenWeatherMapService {
    @GET("data/2.5/weather?q=sydney,AU&appid=2326504fb9b100bee21400190e4dbe6d&units=metric")
    suspend fun getCurrentWeather(): OpenWeatherMapDTO
}