package io.mx51.androidinterview.domain

import io.mx51.androidinterview.data.WeatherDetailsRepository
import io.mx51.androidinterview.data.model.WeatherDetails
import io.mx51.androidinterview.data.model.WeatherUnit
class GetWeatherDetailsUseCase(
    private val weatherDetailsRepository: WeatherDetailsRepository
): UseCase<WeatherUnit, WeatherDetails>() {

    override suspend fun run(params: WeatherUnit): WeatherDetails {
        return weatherDetailsRepository.getWeatherDetails(
            unit = params
        )
    }

}
