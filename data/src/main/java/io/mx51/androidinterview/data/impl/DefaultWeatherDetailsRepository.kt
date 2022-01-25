package io.mx51.androidinterview.data.impl

import io.mx51.androidinterview.data.WeatherDetailsRepository
import io.mx51.androidinterview.data.model.WeatherDetails
import io.mx51.androidinterview.data.retrofit.OpenWeatherMapService

class DefaultWeatherDetailsRepository(
    private val openWeatherMapService: OpenWeatherMapService
): WeatherDetailsRepository {
    override suspend fun getWeatherDetails(): WeatherDetails {
        return openWeatherMapService.getCurrentWeather().toWeatherDetails()
    }
}