package io.mx51.androidinterview.domain

import io.mx51.androidinterview.data.WeatherDetailsRepository
import io.mx51.androidinterview.data.model.WeatherDetails

class GetWeatherDetailsUseCase(
    private val weatherDetailsRepository: WeatherDetailsRepository
): UseCase<Unit, WeatherDetails>() {

    override suspend fun run(params: Unit): WeatherDetails {
        return weatherDetailsRepository.getWeatherDetails()
    }

}
