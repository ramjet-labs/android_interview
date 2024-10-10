package io.mx51.androidinterview.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
interface OpenWeatherMapService {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = "2326504fb9b100bee21400190e4dbe6d",
        @Query("q") city: String = "sydney,AU"
    ): OpenWeatherMapDTO
}
