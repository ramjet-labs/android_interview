package io.mx51.androidinterview.data.impl

import io.mx51.androidinterview.data.WeatherDetailsRepository
import io.mx51.androidinterview.data.model.WeatherDetails
import io.mx51.androidinterview.data.model.WeatherUnit
import io.mx51.androidinterview.data.retrofit.OpenWeatherMapService

class DefaultWeatherDetailsRepository(
    private val openWeatherMapService: OpenWeatherMapService
): WeatherDetailsRepository {
    override suspend fun getWeatherDetails(
        unit: WeatherUnit
    ): WeatherDetails {
        return openWeatherMapService.getCurrentWeather(
            units = if (unit == WeatherUnit.METRIC) "metric" else "imperial"
        ).toWeatherDetails()
    }
}
