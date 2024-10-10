package io.mx51.androidinterview.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.mx51.androidinterview.data.model.WeatherDetails
import io.mx51.androidinterview.data.model.WeatherPreference
import io.mx51.androidinterview.data.model.WeatherUnit
import io.mx51.androidinterview.domain.GetWeatherDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherDetailsUseCase: GetWeatherDetailsUseCase
): ViewModel() {

    val weatherDetails: MutableStateFlow<WeatherDetails?> = MutableStateFlow(null)
    val weatherPreference: MutableStateFlow<WeatherPreference> = MutableStateFlow(WeatherPreference())

    fun getWeatherDetails() {
        viewModelScope.launch {
            weatherDetails.value = getWeatherDetailsUseCase(
                weatherPreference.value.weatherUnit
            )
        }
    }

    fun setWeatherUnit(weatherUnit: WeatherUnit) {
        viewModelScope.launch {
            weatherPreference.value.weatherUnit = weatherUnit
        }
    }
}
