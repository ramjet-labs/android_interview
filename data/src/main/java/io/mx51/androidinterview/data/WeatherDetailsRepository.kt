package io.mx51.androidinterview.data

import io.mx51.androidinterview.data.model.WeatherDetails
import io.mx51.androidinterview.data.model.WeatherUnit

interface WeatherDetailsRepository {
    suspend fun getWeatherDetails(
        unit: WeatherUnit
    ): WeatherDetails
}
